<template>
	<div>

		<!-- User Profile Card -->
		<a-card :bordered="false" class="card-profile-head mt-24" :bodyStyle="{paddingTop: '34px'}">
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
                <a-card :bordered="false" class="header-solid h-full" :bodyStyle="{paddingTop: 0, paddingBottom: '16px' }">
                    <h6 class="font-semibold my-20">Appointment Information</h6>
                    <a-row :gutter="[24, 24]" v-for="order in this.orders" :key="order">
                        <a-col :span="24">
                            <a-card :bordered="false" class="card-billing-info">
                                <div class="col-info">
                                    <a-descriptions :column="1">
                                        <a-descriptions-item label="ID">
                                            {{ order.id }}
                                        </a-descriptions-item>
                                        <a-descriptions-item label="Begin Time">
                                            {{ order.begin }}
                                        </a-descriptions-item>
                                        <a-descriptions-item label="End Time">
                                            {{ order.end }}
                                        </a-descriptions-item>
                                        <a-descriptions-item label="Venue Name">
                                            {{ order.name }}
                                        </a-descriptions-item>
                                        <a-descriptions-item label="Address">
                                            {{ order.address }}
                                        </a-descriptions-item>
                                    </a-descriptions>
                                </div>
                                <div class="col-action">
                                    <a-button type="link" size="small">
                                        <svg width="16" height="16" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-danger" fill-rule="evenodd" clip-rule="evenodd" d="M9 2C8.62123 2 8.27497 2.214 8.10557 2.55279L7.38197 4H4C3.44772 4 3 4.44772 3 5C3 5.55228 3.44772 6 4 6L4 16C4 17.1046 4.89543 18 6 18H14C15.1046 18 16 17.1046 16 16V6C16.5523 6 17 5.55228 17 5C17 4.44772 16.5523 4 16 4H12.618L11.8944 2.55279C11.725 2.214 11.3788 2 11 2H9ZM7 8C7 7.44772 7.44772 7 8 7C8.55228 7 9 7.44772 9 8V14C9 14.5523 8.55228 15 8 15C7.44772 15 7 14.5523 7 14V8ZM12 7C11.4477 7 11 7.44772 11 8V14C11 14.5523 11.4477 15 12 15C12.5523 15 13 14.5523 13 14V8C13 7.44772 12.5523 7 12 7Z" fill="#111827"/>
                                        </svg>
                                        <span class="text-danger">CANCEL</span>
                                    </a-button>
                                </div>
                            </a-card>
                        </a-col>
                    </a-row>
                </a-card>
            </a-col>
		</a-row>
	</div>
</template>

<script>
    import {getUserOrders} from "../api/order";
    import {getUserProfile} from "../api/user";
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
                orders: [],
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
        beforeMount() {
            getUserProfile().then(res => {
                console.log(res.data);
                this.id = res.data.data.id;
                this.username = res.data.data.username;
                this.age = res.data.data.age;
                this.email = res.data.data.email;
                this.name = res.data.data.name;
                this.phoneNumber = res.data.data.phoneNumber;
                if (res.data.data.sex === 1) {
                    this.sex = 'Male'
                }
                else {
                    this.sex = 'Female'
                }
                // refresh
                this.$forceUpdate();
            })
            getUserOrders().then(res => {
                console.log(res)
                this.orders = res.data.data;
                console.log(this.orders);
                this.$forceUpdate();
            })
        },
        methods: {
            geta() {
                getUserOrders().then(res => {
                    console.log(res.data);
                })
            }
        }
    })

</script>

<style lang="scss">
</style>
