import Vue from "vue";
import Router from "vue-router";
import Hello from "@/components/Hello";
import Boards from "@/components/Boards";
import BoardList from "@/components/BoardList";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "Hello",
      component: Hello
    },
    {
      path: "/boards",
      name: "Boards",
      component: Boards
    },
    {
      path: "/boardlist/:categoryNo",
      name: "BoardList",
      component: BoardList
    }
  ]
});
