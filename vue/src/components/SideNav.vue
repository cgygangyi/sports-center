<template>

    <!-- Main Sidebar -->
    <a-layout-sider
        collapsible
        class="sider-primary"
        breakpoint="lg"
        collapsed-width="0"
        width="250px"
        :collapsed="sidebarCollapsed"
        @collapse="$emit('toggleSidebar', ! sidebarCollapsed)"
        :trigger="null"
        :class="['ant-layout-sider-' + sidebarColor, 'ant-layout-sider-' + sidebarTheme]"
        theme="light"
        :style="{ backgroundColor: 'transparent',}">
        <div class="brand"><img src="images/logo-ct-black.png" alt=""> <span>Stadium</span></div>
        <hr>

        <a-menu theme="light" mode="inline">
            <a-menu-item>
                <router-link to="/home">
						<span class="icon">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
                                <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
                                <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
                            </svg>
						</span>
                    <span class="label">Home</span>
                </router-link>
            </a-menu-item>
            <a-menu-item>
                <router-link to="/venues">
						<span class="icon">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-table" viewBox="0 0 16 16">
                            <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm15 2h-4v3h4V4zm0 4h-4v3h4V8zm0 4h-4v3h3a1 1 0 0 0 1-1v-2zm-5 3v-3H6v3h4zm-5 0v-3H1v2a1 1 0 0 0 1 1h3zm-4-4h4V8H1v3zm0-4h4V4H1v3zm5-3v3h4V4H6zm4 4H6v3h4V8z"/>
                        </svg>
						</span>
                    <span class="label">Venues</span>
                </router-link>
            </a-menu-item>
            <a-menu-item class="menu-item-header">
                Account Pages
            </a-menu-item>
            <a-menu-item>
                <router-link to="/profile">
						<span class="icon">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-square" viewBox="0 0 16 16">
                                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z"/>
                            </svg>
						</span>
                    <span class="label">Profile</span>
                </router-link>
            </a-menu-item>
            <a-menu-item>
                <router-link to="/payment">
						<span class="icon">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-credit-card" viewBox="0 0 16 16">
                                <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4zm2-1a1 1 0 0 0-1 1v1h14V4a1 1 0 0 0-1-1H2zm13 4H1v5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V7z"/>
                                <path d="M2 10a1 1 0 0 1 1-1h1a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1v-1z"/>
                            </svg>
						</span>
                    <span class="label">Payment</span>
                </router-link>
            </a-menu-item>
            <a-menu-item>
                <router-link to="/login">
						<span class="icon">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"/>
                                <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
                            </svg>
						</span>
                    <span class="label">Logout</span>
                </router-link>
            </a-menu-item>
        </a-menu>
        <!-- / Sidebar Navigation Menu -->

    </a-layout-sider>
    <!-- / Main Sidebar -->

</template>

<script>
export default ({
    props: {
        // Sidebar collapsed status.
        sidebarCollapsed: {
            type: Boolean,
            default: false,
        },
        // Main sidebar color.
        sidebarColor: {
            type: String,
            default: "primary",
        },
        // Main sidebar theme : light, white, dark.
        sidebarTheme: {
            type: String,
            default: "light",
        },
    },
    data() {
        return {
            // sidebarCollapsedModel: this.sidebarCollapsed,
        }
    },

    methods: {
        showConfirm() {
            this.$confirm({
                title: 'Do you want to delete these items?',
                content: 'When clicked the OK button, this dialog will be closed after 1 second',
                onOk() {
                    return new Promise((resolve, reject) => {
                        setTimeout(Math.random() > 0.5 ? resolve : reject, 1000);
                    }).catch(() => console.log('Oops errors!'));
                },
                onCancel() {},
            });
        },
    },
})
</script>
