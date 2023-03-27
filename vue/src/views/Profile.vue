<template>
	<div>
		<div class="profile-nav-bg" style="background-image: url('images/bg-profile.jpg')"></div>

		<!-- User Profile Card -->
		<a-card :bordered="false" class="card-profile-head" :bodyStyle="{padding: 0,}">
			<template #title>
				<a-row type="flex" align="middle">
					<a-col :span="24" :md="12" class="col-info">
						<a-avatar :size="74" shape="square" src="images/face-1.jpg" />
						<div class="avatar-info">
							<h4 class="font-semibold m-0">{{username}}</h4>
						</div>
					</a-col>
					<a-col :span="24" :md="12" style="display: flex; align-items: center; justify-content: flex-end">
                        <a-button size="small">Edit </a-button>
					</a-col>
				</a-row>
			</template>
		</a-card>

		<a-row type="flex" :gutter="24">
			<a-col :span="24" :md="8" class="mb-24">
				<CardProfileInformation></CardProfileInformation>
			</a-col>

            <a-col :span="24" :md="16" class="mb-24">

                <CardBillingInfo></CardBillingInfo>

            </a-col>
		</a-row>
	</div>
</template>

<script>

	import CardPlatformSettings from "../components/Cards/CardPlatformSettings"
	import CardProfileInformation from "../components/Cards/CardProfileInformation"
    import CardBillingInfo from "../components/Cards/CardBillingInfo"

	export default ({
		components: {
			CardPlatformSettings,
			CardProfileInformation,
            CardBillingInfo
		},
		data() {
			return {

				profileHeaderBtns: 'overview',
                id: 1,
                username: "",
                age: 0,
                email: "",
                name: "",
                password: "",
                phoneNumber: "",
                sex: 0,
			}
		},
        start() {
            // get user session
            let user = JSON.parse(localStorage.getItem("user"));
            this.id = user.id;
            this.username = user.username;
            this.age = user.age;
            this.email = user.email;
            this.name = user.name;
            this.password = user.password;
            console.log(user);
        }
    })

</script>

<style lang="scss">
</style>
