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
                        <a-button size="small" @click="geta()">Edit </a-button>
					</a-col>
				</a-row>
			</template>
		</a-card>

		<a-row type="flex" :gutter="24">
			<a-col :span="24" :md="8" class="mb-24">
				<CardProfileInformation
                :id="id"
                :username="username"
                :age="age"
                :email="email"
                :name="name"
                :password="password"
                :phoneNumber="phoneNumber"
                :sex="sex"
                ></CardProfileInformation>
			</a-col>

            <a-col :span="24" :md="16" class="mb-24">

                <CardBillingInfo></CardBillingInfo>

            </a-col>
		</a-row>
	</div>
</template>

<script>

	import CardProfileInformation from "../components/Cards/CardProfileInformation"
    import CardBillingInfo from "../components/Cards/CardBillingInfo"

	export default ({
		components: {
			CardProfileInformation,
            CardBillingInfo
		},
		data() {
			return {
				profileHeaderBtns: 'overview',
                id: 1,
                username: '',
                age: 0,
                email: '',
                name: '',
                password: 0,
                phoneNumber: this.user.phoneNumber,
                sex: '',
			}
		},
        beforeCreate() {
            let user = JSON.parse(sessionStorage.getItem("user"));
            this.id = user.id;
            this.username = user.username;
            this.age = user.age;
            this.email = user.email;
            this.name = user.name;
            this.password = user.password;
            this.phoneNumber = user.phoneNumber;
            if (user.sex === 1) {
                this.sex = 'Male'
            }
            else {
                this.sex = 'Female'
            }
        },
        methods: {
            geta() {
                console.log(this.username);
                console.log(JSON.parse(sessionStorage.getItem("user")));
            }
        }
    })

</script>

<style lang="scss">
</style>
