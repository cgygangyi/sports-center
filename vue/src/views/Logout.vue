<template>

</template>

<script>
export default {
    name: "Logout",
    beforeCreate() {
        localStorage.removeItem("token");
        window.location.reload();
        this.$router.push({ name: "Home" });
    }
}


</script>

<style scoped>

</style>
