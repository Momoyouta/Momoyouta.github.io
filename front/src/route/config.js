import {createRouter, createWebHistory} from "vue-router";
import {default as adminSideBar} from "../layout/components/admin/SideBar.vue";
import {default as userSideBar} from "../layout/components/user/SideBar.vue";
import {default as adminTopBar} from "../layout/components/admin/TopBar.vue";
import {default as userTopBar} from "../layout/components/user/TopBar.vue";
import {ROUTE_PATH} from "./pathset.js";
import AddAni from "../components/admin/animation/AddAni.vue";
import UpdateAni from "@/components/admin/animation/UpdateAni.vue";
import AnimationCard from "@/components/common/AnimationCard.vue";
import test from "@/components/test/AnicardTest.vue";
import WeekList from "@/components/home/WeekList.vue";
import WeeklistTest from "@/components/test/WeeklistTest.vue";
import WeeklistMG from "@/components/admin/WeeklistMG.vue";
import {AXIOS_URL} from "@/common/axios_url.js";
import HomePage from "@/layout/components/user/page/HomePage.vue";
import RecgroundPage from "@/layout/components/user/page/RecgroundPage.vue";
import AnimefollowPage from "@/layout/components/user/page/AnimefollowPage.vue";
import DirectoryPage from "@/layout/components/user/page/DirectoryPage.vue";
import DayupdatePage from "@/layout/components/user/page/DayupdatePage.vue";
import UserTest from "@/layout/components/user/page/UserTest.vue";



const routes =[
    {path:'/admin/:pathMatch(.*)*', components:{SideNavbar:adminSideBar,TopNavbar:adminTopBar}},
    {path:`/admin/${ROUTE_PATH.ADMIN_ANI}/${ROUTE_PATH.ADMIN_ANI_ADD}`,components:{SideNavbar:adminSideBar,main:AddAni,TopNavbar:adminTopBar}},
    {path:`/admin/${ROUTE_PATH.ADMIN_ANI}/${ROUTE_PATH.ADMIN_ANI_UPDATE}`,components:{SideNavbar:adminSideBar,main:UpdateAni,TopNavbar:adminTopBar}},
    {path:`/admin/${ROUTE_PATH.ADMIN_WEEKLIST}`,components:{SideNavbar:adminSideBar,main:WeeklistMG,TopNavbar:adminTopBar}},
    {path:`/admin/test/anicard`,components:{SideNavbar:adminSideBar,main:test,TopNavbar:adminTopBar}},
    {path:`/admin/test/weeklist`,components:{SideNavbar:adminSideBar,main:WeeklistTest,TopNavbar:adminTopBar}},

    {path:'/user/:pathMatch(.*)*',alias:'/',components:{SideNavbar:userSideBar,main:HomePage,TopNavbar:userTopBar}},
    {path:`/user/recmground`,alias:'/recmground',components:{SideNavbar:userSideBar,main:RecgroundPage,TopNavbar:userTopBar}},
    {path:`/user/animefollow`,alias:'/animefollow',components:{SideNavbar:userSideBar,main:AnimefollowPage,TopNavbar:userTopBar}},
    {path:`/user/directory`,alias:'/directory',components:{SideNavbar:userSideBar,main:DirectoryPage,TopNavbar:userTopBar}},
    {path:`/user/dayupdate`,alias:'/dayupdate',components:{SideNavbar:userSideBar,main:DayupdatePage,TopNavbar:userTopBar}},
    {path:`/user/test`,alias:'/test',components:{SideNavbar:userSideBar,main:UserTest,TopNavbar:userTopBar}},

]

export  const router = createRouter({
    history: createWebHistory(),
    routes,
})

router.beforeEach((to, from, next) => {
    const paths=to.path.split("/");
    if(paths[1]=== 'user') {
        if(paths[2]==='')
            next('/');
        else
            next(to.path.slice(6));
    }else{
        next();
    }
})