<template>
	<div>
		<div class="sign-up-header" style="background-image: url('images/a.jpg')">
			<div class="content">
				<h1 class="mb-5">Sign Up</h1>
			</div>
		</div>

		<!-- Sign Up Form -->
		<a-card :bordered="false" class="card-signup header-solid h-full" :bodyStyle="{paddingTop: 0}">
			<a-form
				id="components-form-demo-normal-login"
				:form="form"
				class="login-form my-25"
				@submit="handleSubmit"
			>
				<a-form-item class="mb-10">
					<a-input
						v-decorator="[
						'Username',
						{ rules: [{ required: true, message: 'Please input your username!' }] },
						]"
						placeholder="Userame"
					>
					</a-input>
				</a-form-item>
				<a-form-item class="mb-10">
					<a-input
						v-decorator="[
						'email',
						{ rules: [{ required: true, message: 'Please input your email!' }] },
						]"
						placeholder="Email"
					>
					</a-input>
				</a-form-item>
				<a-form-item class="mb-5">
					<a-input
						v-decorator="[
						'password',
						{ rules: [{ required: true, message: 'Please input your Password!' }] },
						]"
						type="password"
						placeholder="Password"
					>
					</a-input>
				</a-form-item>
                <a-form-item class="mb-5">
                    <a-input
                        v-decorator="[
						'Confirm password',
						{ rules: [{ required: true, message: 'Please input your Password!' }] },
						]"
                        type="password"
                        placeholder="Confirm password"
                    >
                    </a-input>
                </a-form-item>
                <a-form-item class="mb-10">
                    <a-input
                        v-decorator="[
                        'name',
						{ rules: [{ required: true, message: 'Please input your name!' }] },
						]"
                        placeholder="Name"
                    >
                    </a-input>
                </a-form-item>
                <a-form-item class="mb-10">
                    <a-input
                        v-decorator="[
                        'phoneNumber',
						{ rules: [{ required: true, message: 'Please input your phoneNumber!' }] },
						]"
                        placeholder="phone number"
                    >
                    </a-input>
                </a-form-item>
                <a-form-item class="mb-10">
                    <a-input
                        v-decorator="[
						'age',
                        { rules: [{ required: true, message: 'Please input your age!' }] },
                        ]"
                        placeholder="Age"
                    >
                    </a-input>
                </a-form-item>
                <a-form-item class="mb-10">
                    <a-input
                        v-decorator="[
                        'sex',
						{ rules: [{ required: true, message: 'Please input your sex!' }] },
						]"
                        placeholder="Sex"
                    >
                    </a-input>
                </a-form-item>
				<a-form-item>
					<a-button type="primary" block html-type="submit" class="login-form-button">
						SIGN UP
					</a-button>
				</a-form-item>
			</a-form>
			<p class="font-semibold text-muted text-center">Already have an account? <router-link to="/login" class="font-bold text-dark">Sign In</router-link></p>
		</a-card>
		<!-- / Sign Up Form -->
	</div>
</template>

<script>

	export default ({
		data() {
			return {
			}
		},
		beforeCreate() {
			// Creates the form and adds to it component's "form" property.
			this.form = this.$form.createForm(this, { name: 'normal_login' });
		},
		methods: {
			// Handles input validation after submission.
			handleSubmit(e) {
				e.preventDefault();
				this.form.validateFields((err, values) => {
					if ( !err ) {
						console.log('Received values of form: ', values) ;
					}
				});
			},
		},
	})

</script>

<style lang="scss">
</style>
