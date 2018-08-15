<template>
    <div>
        <b-card-group deck class="m-3">
            <b-card header="카테고리 게시판 정보 가져오기">
                <b-form-input v-model="categoryNo1" class="mb-3"
                  type="text"
                  placeholder="카테고리 번호"></b-form-input>
                <b-form-textarea v-model="getBoardsResult" class="mb-3"
                placeholer="categoryNo에 맞는 게시판 글들 가져오기"
                :rows="3"
                :max-rows="6">
                </b-form-textarea>
                <b-button @click="getBoards"
                variant="success">카테고리 정보 가져오기
                </b-button>
            </b-card>

            <b-card header="게시판 정보 가져오기">
                <b-form-input v-model="categoryNo2" class="mb-3"
                  type="text"
                  placeholder="카테고리 번호"></b-form-input>
                <b-form-input v-model="boardNo2" class="mb-3"
                  type="text"
                  placeholder="게시판 번호"></b-form-input>
                <b-form-textarea v-model="getBoardResult" class="mb-3"
                placeholer="categoryNo, boardNo에 맞는 게시판 글들 가져오기"
                :rows="3"
                :max-rows="6">
                </b-form-textarea>
                <b-button @click="getBoard"
                variant="success">게시판 정보 가져오기
                </b-button>
            </b-card>
        </b-card-group>
    </div>
</template>

<script>
export default {
    name: "Boards",
    data() {
        return {
            getBoardsResult: "",
            getBoardResult: ""
        };
    },
    methods: {
        getBoards() {
            this.$axios
                .get("http://localhost:8081/boards/" + this.categoryNo1)
                .then(res => {
                    this.getBoardsResult = JSON.stringify(res.data);
                })
                .catch(err => {
                    this.getBoardsResult = JSON.stringify(err);
                });
        },
        getBoard() {
            this.$axios
                .get(
                    "http://localhost:8081/boards/" +
                        this.categoryNo2 +
                        "/board/" +
                        this.boardNo2
                )
                .then(res => {
                    this.getBoardResult = JSON.stringify(res.data);
                })
                .catch(err => {
                    this.getBoardResult = JSON.stringify(err);
                });
        }
    }
};
</script>