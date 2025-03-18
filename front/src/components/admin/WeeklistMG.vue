<template>
  <div class="main-weeklist">
      <div class="head-count">
        <ul class="count-ul">
          <li v-for="(day, index) in ['周一', '周二', '周三', '周四', '周五', '周六', '周日']">
            <div class="title">
              {{day}}
            </div>
            <span>{{aniCount[index]}}部</span>
          </li>
        </ul>
      </div>
      <div class="top">
        <div class="nav">
          <ul class="nav-ul">
            <li v-for="(day, index) in ['周一', '周二', '周三', '周四', '周五', '周六', '周日']"
                :key="index"
                :class="{ active: activeDay === index}"
                @click="changeList(index)">
              <a href="#">{{ day }}</a>
            </li>
          </ul>
        </div>
        <span class="tot">周共 {{totAni}} 部</span>
        <div class="btn-list">
          <ul class="btn-ul">
            <li><button @click="clean">清空</button></li>
            <li><button @click="updateDay(activeDay)">提交</button></li>
            <li><button @click="updateAll">提交所有</button></li>
          </ul>
        </div>
      </div>
      <div class="content">
        <ul class="ani-ul">
          <li v-for="(ani,index) in aniList[activeDay]" :key="index">
            <a class="icon" @click.stop="del(index)">
              <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-chacha"></use>
              </svg>
            </a>
            <AnimationCard class="aniCard"  style="width: 100%;font-size: 1rem" :ani="ani.data" :show-con="ani.show"></AnimationCard>
          </li>
          <li><div class="add" @click="showModal=true"></div></li>
        </ul>
      </div>
      <FloatSearchbox v-if="showModal" @floatClose="showModal=false" @getAniCart="setDaylist"></FloatSearchbox>

  </div>
</template>

<script setup>
import AnimationCard from "@/components/common/AnimationCard.vue";
import {onMounted, reactive, ref} from "vue";
import axios from "axios";
import {AXIOS_URL} from "@/common/axios_url.js";
import FloatSearchbox from "@/components/common/FloatSearchbox.vue";
const aniList=reactive([[],[],[],[],[],[],[]]);
const activeDay=ref(0);
const totAni=ref(0);
const aniCount=reactive([]);
const showModal=ref(false)
const axios_is=axios.create({
  baseURL: `${AXIOS_URL.BASIC}`,
})
onMounted(()=>{
  getData();
});
function changeList(day){
  activeDay.value=day
}

async function getData(){
  for(let day=0;day<7;day++){
    await axios_is.get(`/user${AXIOS_URL.WEEKLIST_DAY_RQ}`,{
      params:{
        day: day+1,
      }
    })
        .then(res=>{
          for(let item of res.data.data){
            let anttp={
              show:{
                score: false,
                state: true,
                date: true,
                name: true
              },
              data: {
                id:item.id,
                name:item.name,
                image:item.image,
                ep:item.ep,
                end:item.end,
                updateTime:item.updateTime,
              }
            }
            let date=anttp.data.updateTime.split("-");
            anttp.data.updateTime=date[1]+'/'+date[2].split("T")[0]
            aniList[day].push(anttp);

          }

        })
        .catch(err=>{console.log(err)});
    let anis=aniList[day].length;
    totAni.value+=anis;
    aniCount.push(anis);
  }
}


function clean(){
  aniList[activeDay.value-1].length=0;
}

function del(index){
  aniList[activeDay.value].splice(index,1);
}
function setDaylist(aniCart){
  for(let item of aniCart){
    let anttp={
      show:{
        score: false,
        state: true,
        date: true,
        name: true
      },
      data: {
        id:item.id,
        name:item.name,
        image:item.image,
        ep:item.ep,
        end:item.end,
        updateTime:item.updateTime,
      }
    }
    aniList[activeDay.value].push(anttp);
  }
  aniCount[activeDay.value]=aniList[activeDay.value].length;
  totAni.value+=aniCart.length;
}
function updateDay(day){
  day++;
  let dayList=[];
  for(let item of aniList[day-1]){
    let wk={
      aniId:item.data.id,
      name:item.data.name,
      days: day,
      updateTime:'',
    }
    dayList.push(wk);
  }
  axios_is.put(`${AXIOS_URL.WEEKLIST_DAY_UPDATE}/${day}`,dayList)
      .then(res=>{
        console.log(res.data)
      })
      .catch(err=>{console.log(err)});
}
function updateAll(){
  for(let i=0;i<7;i++){
    updateDay(i);
  }
}

</script>

<style scoped>
.main-weeklist{
  width: 100%;
  padding: 1rem 1rem;
  background-color: white;
}
.top {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1rem;

}
ul{
  display: flex;
}

.head-count{
  border-radius: 5px;
  border: var(--nav-ul-bg) solid 1px;
  overflow: hidden;
  margin-bottom: 1rem;
}
.count-ul{
  display: grid;
  grid-template-columns: repeat(7,1fr);
}
.count-ul li{
  text-align: center;
  padding: 3px 0;
}
.count-ul li:nth-child(1n){

  background-color: var(--nav-ul-bg);
}
.count-ul li:nth-child(2n){
  background: none;
}
.count-ul li span{
  font-size: 75%;
}

.btn-ul li{
  padding-right:1rem;
}
.btn-ul li button{
  padding: 3px 6px;
  font-size: 1rem;
}
.tot{
  background-color: var(--nav-ul-bg);
  padding: 4px 8px;
  border-radius: 5px;
}

.nav-ul a{
  text-decoration: none;
  color: black;
}
.nav{
  padding: 3px 3px;
  border-radius: 6px;
  background-color: var(--nav-ul-bg);
}
.nav-ul li{
  font-size: 1rem;
  width: 20%;
  margin-right: 10px;
  padding: 5px 10px;
  text-align: center;
  border-radius: 6px;
}
.active{
  background: white;
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
  box-sizing: border-box;
  cursor: pointer;
  position: relative;
}
.icon{
  position: absolute;
  z-index: 2;
  font-size: 20px;
}

.aniCard{
  z-index: 1;
}
.ani-ul li:nth-child(6n){
  margin-right: 0;
}
.add{
  width: 100%;
  background: url("/src/assets/img/weeklistmg_add.png");
  background-size: cover;
  background-position: center;
  border-radius: 5%;
  aspect-ratio: 190.5/266.7;
}

</style>