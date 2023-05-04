<template>
    <div></div>
</template>

<script>
export default {
    beforeCreate() {
        this.$router.replace({ path: '/empty' })
        localStorage.removeItem('token')
        this.$router.replace({ path: '/empty' })
        this.$message.success('Logout successfully')
    }
}

</script>

<style scoped>

</style>
