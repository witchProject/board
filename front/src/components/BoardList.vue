<template>
  <b-table striped hover :items="items" :fields="fields"></b-table>
</template>

<script>
import moment from "moment";

const items = [];

export default {
    name: "BoardList",
    data() {
        return {
            fields: [
                {
                    key: "boardNo",
                    label: "번호",
                    sortable: true
                },
                {
                    key: "title",
                    label: "제목"
                },
                {
                    key: "content",
                    label: "내용"
                },
                {
                    key: "name",
                    label: "작성자"
                },
                {
                    key: "registerYmdt",
                    label: "등록일",
                    formatter: value => {
                        return moment(String(value)).format('YYYY-MM-DD hh:mm')
                    }
                },
                {
                    key: "visitorCnt",
                    label: "조회수"
                }
            ],
            items: items
        };
    },
    mounted() {
        this.getBoards();
    },
    methods: {
        getBoards() {
            this.$axios
                .get("http://localhost:8081/boards/" + 1)
                .then(res => {
                    console.log(res.data);
                    this.items = res.data;
                })
                .catch(err => {
                    this.getBoardsResult = JSON.stringify(err);
                });
        }
    }
};
</script>