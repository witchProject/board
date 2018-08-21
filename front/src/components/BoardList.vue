<template>
<div>
    <b-table striped hover :items="items" :fields="fields" :current-page="currentPage"></b-table>
    <b-pagination align="center" size="md" :total-rows="100" v-model="currentPage" :per-page="10" @change="getBoards">
    </b-pagination>
</div>
</template>

<script>
import moment from "moment";

const items = [];

export default {
    name: "BoardList",
    data() {
        return {
            currentPage: 1,
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
                        return moment(String(value)).format("YYYY-MM-DD hh:mm");
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
        console.log(this.$route.params);
        console.log(this.$route.params.categoryNo);
        console.log(this.$route.query.pageNumber);
    },
    methods: {
        getBoards(page) {
            this.currentPage = page;
            this.$axios
                .get(
                    "http://localhost:8081/boards/" +
                        this.$route.params.categoryNo +
                        "?pageNumber=" +
                        this.currentPage
                )
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