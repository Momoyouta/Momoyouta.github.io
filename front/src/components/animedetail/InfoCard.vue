<template>
  <div class="box">
    <div class="left">
      <img :src="img" alt="" referrerpolicy="no-referrer">
    </div>
    <div class="right">
      <div class="rtop-box">
        <div class="name-box">
          <h2>一杆青空</h2>
          <TagList class="taglist-box" :items="tags"></TagList>
          <ul class="state ">
            <li>
              <div class="state-title">views</div>
              <div class="state-data">1.2k次</div>
            </li>
            <li>
              <div class="state-title">views</div>
              <div class="state-data">1.2k次</div>
            </li>
            <li>
              <div class="state-title">views</div>
              <div class="state-data">1.2k次</div>
            </li>
          </ul>
        </div>
        <div class="score">
          <div class="text">9.9</div>
          <div class="star">
            <p>⭐⭐⭐⭐⭐</p>
            <p>xxx人评</p>
          </div>
        </div>
      </div>
      <div class="rbottom-box">
        <div class="profile">
          简介：“如果就这样毕业，我可不想只是个无名小卒啊！”青羽美波陷入了烦恼。她没有什么特别擅长的技能
          ，也没有什么特别想做的事情。在花团锦簇的高中生活中，就这样做一个普通的配角角色，真的好吗？
          美波离开了学校，开始寻找属于自己的“特别的特别”。偶然来到的，是附近的高尔夫练习场。在那里的打工女孩茜遥向她打招呼
          ，美波拿起了高尔夫球杆——“实用型球杆”。这就是美波与高尔夫的邂逅。与天才型的高尔夫球手遥
          ，以及立志成为网红的星美彩花一起，美波在寻找自己成为“主人公”的那一刻！作为超级新手的美波，今天又挥起了球杆。
        </div>
        <div class="btn-box">
          <button class="btn">
            <span class="iconfont icon-aixin"></span>
            加入追番
          </button>
          <button class="btn">
            <span class="iconfont icon-aixin"></span>
            收藏
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>

import {ref} from 'vue';
import TagList from "@/components/common/TagList.vue";
import imgg from '/assets/img/ani_test2.webp'
const img=ref(imgg)
const tags=["日常", "搞笑","运动"]
</script>

<style scoped>
.box{
  display: flex;
  height: 22rem;
  border-radius: 1rem;
  overflow: hidden;
}
.left{
  width: 20%;
  aspect-ratio: 190/320;
  background-color: var(--side-bg);
}
.left img{
  width: 100%;
  aspect-ratio: 190/280;
  border-radius: 1rem;
}
.right{
  flex:1;
}
.rtop-box{
  display: flex;
  position: relative;
  height: 40%;
  align-items: end;
}
.name-box{

}
.taglist-box{
  margin-left: 1rem;
}
h2{
  margin-left: 1.5rem;
  margin-bottom: 0.5rem;
}
.state{
  display: flex;
  width: fit-content;
  margin-left: 1rem;
  margin-bottom: 0.5rem;
}
.state li{
  padding: 0.1rem 0.5rem;
  border-right: var(--btn-login) solid 0.25rem;
}

.state li:last-child{
  border-right: none;
}
.rbottom-box{
  height: 60%;
  position: relative;
  padding: 1rem 1rem;
  border-radius: 0 1rem 1rem 0;
  background-color: var(--side-bg);
}
.profile{
  border-bottom: var(--btn-login) solid 2px;
  font-size: 0.8rem;
  margin-bottom: 1rem;
  padding-bottom: 1rem;
}
.btn-box{
  position: absolute;
  right: 1.5rem;
  bottom: 1.5rem;
}
.btn{
  padding: 0.5rem 1rem;
  border-radius: 1.2rem;
  margin-left: 1rem;
  border: none;
  background-color: var(--btn-login);
  color: #fff;
}
.btn:hover{
  background-color: var(--btn-login-hover);
}
.score{
  display: flex;
  position: absolute;
  right: 0;
  bottom: 30%;
  border-right: var(--btn-login) solid 0.25rem;
}
.score .text{
  text-align: center;
  font-size: 2rem;
}
.star{
  text-align: center;
}
</style>