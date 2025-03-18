<template>
  <div class="wapper">
    <router-view name="SideNavbar"/>
    <RouterLink to="/admin">go to admin</RouterLink>
    <RouterLink to="/user/">go to user</RouterLink>
  </div>
</template>

<script setup>

</script>

<style scoped>

.wapper{
  margin-top:20px;
}
</style>