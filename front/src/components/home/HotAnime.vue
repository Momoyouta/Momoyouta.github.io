<template>
  <div class="main">
    <div class="top">
     <span class="title">
      正在热映
     </span>
    </div>
    <div class="content">
      <ul class="ani-ul">
        <li v-for="(ani,index) in aniList" :key="index">
          <AnimationCard style="width: 100%;font-size: 16px" :ani="ani.data" :show-con="ani.show"></AnimationCard>
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import AnimationCard from "@/components/common/AnimationCard.vue";
import {onMounted, reactive, ref} from "vue";
import axios from "axios";
import {AXIOS_URL} from "@/common/axios_url.js";
const aniList=reactive([]);
const axios_instance=axios.create({
  baseURL: `${AXIOS_URL.BASIC}`,
})
onMounted(()=>{
  getData();
});
function getData(){
  axios_instance.get(`/admin${AXIOS_URL.SEARCH_ANI}/bynamelike`,{
    params:{
      name: '',
      page: 1,
      pageSize: 99999,
    }
  })
      .then(res => {
        for(let item of res.data.data) {
          let anttp = {
            show: {
              score: false,
              date: false,
              state: true,
              name: true
            },
            data: {
              id: item.id,
              name: item.name,
              image: item.image,
              ep: item.ep,
              end: item.end,
              updateTime: item.updateTime,
            }
          }
          // let date = anttp.data.updateTime.split("-");
          // anttp.data.updateTime = date[1] + '/' + date[2].split("T")[0];
          aniList.push(anttp);
        }
      })
      .catch(err=>{console.log(err)})
}


</script>

<style scoped>


.top{
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1rem;

}
ul{
  display: flex;
}

.title{
  font-weight: bold;
  font-size: 1.2rem;
}

.nav-ul li:last-child{
  margin-right: 0;
}

.ani-ul{
  flex-wrap: wrap;
}

.ani-ul li{
  width: 15%;
  margin-right: 2%;
  margin-bottom: 2%;
  box-sizing: border-box;
  cursor: pointer;
}

.ani-ul li:nth-child(6n){
  margin-right: 0;
}
</style>