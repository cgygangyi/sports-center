<template>
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

        <!-- Sidebar Navigation Menu -->
        <a-menu theme="light" mode="inline">
            <a-menu-item>
                <router-link to="/admin/home">
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
                <router-link to="/admin/venues">
						<span class="icon">
							<svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path d="M4 4C2.89543 4 2 4.89543 2 6V7H18V6C18 4.89543 17.1046 4 16 4H4Z" fill="#111827"/>
								<path fill-rule="evenodd" clip-rule="evenodd" d="M18 9H2V14C2 15.1046 2.89543 16 4 16H16C17.1046 16 18 15.1046 18 14V9ZM4 13C4 12.4477 4.44772 12 5 12H6C6.55228 12 7 12.4477 7 13C7 13.5523 6.55228 14 6 14H5C4.44772 14 4 13.5523 4 13ZM9 12C8.44772 12 8 12.4477 8 13C8 13.5523 8.44772 14 9 14H10C10.5523 14 11 13.5523 11 13C11 12.4477 10.5523 12 10 12H9Z" fill="#111827"/>
							</svg>
						</span>
                    <span class="label">Venues</span>
                </router-link>
            </a-menu-item>
            <a-menu-item>
                <router-link to="/admin/users">
						<span class="icon">
							<svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path d="M4 4C2.89543 4 2 4.89543 2 6V7H18V6C18 4.89543 17.1046 4 16 4H4Z" fill="#111827"/>
								<path fill-rule="evenodd" clip-rule="evenodd" d="M18 9H2V14C2 15.1046 2.89543 16 4 16H16C17.1046 16 18 15.1046 18 14V9ZM4 13C4 12.4477 4.44772 12 5 12H6C6.55228 12 7 12.4477 7 13C7 13.5523 6.55228 14 6 14H5C4.44772 14 4 13.5523 4 13ZM9 12C8.44772 12 8 12.4477 8 13C8 13.5523 8.44772 14 9 14H10C10.5523 14 11 13.5523 11 13C11 12.4477 10.5523 12 10 12H9Z" fill="#111827"/>
							</svg>
						</span>
                    <span class="label">Users</span>
                </router-link>
            </a-menu-item>
            <a-menu-item>
                <router-link to="/admin/states">
						<span class="icon">
							<svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path d="M4 4C2.89543 4 2 4.89543 2 6V7H18V6C18 4.89543 17.1046 4 16 4H4Z" fill="#111827"/>
								<path fill-rule="evenodd" clip-rule="evenodd" d="M18 9H2V14C2 15.1046 2.89543 16 4 16H16C17.1046 16 18 15.1046 18 14V9ZM4 13C4 12.4477 4.44772 12 5 12H6C6.55228 12 7 12.4477 7 13C7 13.5523 6.55228 14 6 14H5C4.44772 14 4 13.5523 4 13ZM9 12C8.44772 12 8 12.4477 8 13C8 13.5523 8.44772 14 9 14H10C10.5523 14 11 13.5523 11 13C11 12.4477 10.5523 12 10 12H9Z" fill="#111827"/>
							</svg>
						</span>
                    <span class="label">States</span>
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
    },
})
</script>
