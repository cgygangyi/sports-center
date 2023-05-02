<template>
    <div></div>
</template>

<script>
export default {
    beforeCreate() {
        localStorage.removeItem('token')
        window.location.reload()
        this.$router.push({ name: 'Home' })
    }
}

</script>

<style scoped>

</style>
