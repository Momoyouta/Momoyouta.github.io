import {createRouter, createWebHistory, useRoute} from "vue-router";
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
import AnimeDetail from "@/layout/components/user/page/AnimeDetailPage.vue";
import AnimeSearchPage from "@/layout/components/user/page/AnimeSearchPage.vue";

const routes =[
    {path:'/admin/:pathMatch(.*)*', components:{SideNavbar:adminSideBar,TopNavbar:adminTopBar}},
    {path:`/admin/${ROUTE_PATH.ADMIN_ANI}/${ROUTE_PATH.ADMIN_ANI_ADD}`,components:{SideNavbar:adminSideBar,main:AddAni,TopNavbar:adminTopBar}},
    {path:`/admin/${ROUTE_PATH.ADMIN_ANI}/${ROUTE_PATH.ADMIN_ANI_UPDATE}`,components:{SideNavbar:adminSideBar,main:UpdateAni,TopNavbar:adminTopBar}},
    {path:`/admin/${ROUTE_PATH.ADMIN_WEEKLIST}`,components:{SideNavbar:adminSideBar,main:WeeklistMG,TopNavbar:adminTopBar}},
    {path:`/admin/test/anicard`,components:{SideNavbar:adminSideBar,main:test,TopNavbar:adminTopBar}},
    {path:`/admin/test/weeklist`,components:{SideNavbar:adminSideBar,main:WeeklistTest,TopNavbar:adminTopBar}},

    {path:`/user/recmground`,alias:'/recmground',components:{SideNavbar:userSideBar,main:RecgroundPage,TopNavbar:userTopBar}},
    {path:`/user/animefollow`,alias:'/animefollow',components:{SideNavbar:userSideBar,main:AnimefollowPage,TopNavbar:userTopBar}},
    {path:`/user/directory`,alias:'/directory',components:{SideNavbar:userSideBar,main:DirectoryPage,TopNavbar:userTopBar}},
    {path:`/user/dayupdate`,alias:'/dayupdate',components:{SideNavbar:userSideBar,main:DayupdatePage,TopNavbar:userTopBar}},
    {name:'getAnimeDetail' ,path:`/user/ani/:animeid`,alias:'/ani/:animeid',components:{SideNavbar:userSideBar,main:AnimeDetail,TopNavbar:userTopBar}
        ,props: {
            SideNavbar: false,
            main: true,
            TopNavbar: false,
        }
    },
    {name:'searchAnime' ,path:`/user/search/:keyword`,alias:'/search/:keyword',components:{SideNavbar:userSideBar,main:AnimeSearchPage,TopNavbar:userTopBar}
        ,props: {
            SideNavbar: false,
            main: true,
            TopNavbar: false,
        }
    },
    {path:`/user/test`,alias:'/test',components:{SideNavbar:userSideBar,main:UserTest,TopNavbar:userTopBar}},
    {path:'/user/:pathMatch(.*)*',alias:'/',components:{SideNavbar:userSideBar,main:HomePage,TopNavbar:userTopBar}},
]

export  const router = createRouter({
    history: createWebHistory(),
    routes,
})

router.beforeEach((to, from, next) => {
    const paths = to.path.split("/");
    if (paths[1] === 'user') {
        const newPath = paths[2] === '' ? '/' : to.path.slice(5);
        router.replace(newPath); // 替换当前历史记录
        return; // 终止后续逻辑
    }
    next();
})