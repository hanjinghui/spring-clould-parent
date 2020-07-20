<template>
<div>
<div class="add-info-whole">
    <el-form ref="form" :model="detailData" label-width="20%">
      <el-form-item label="服务器地址:">
        <el-input v-model="detailData.host" class="form-input" maxlength="150" disabled></el-input>
      </el-form-item>
      <el-form-item label="端口:">
        <el-input v-model="detailData.port" class="form-input" maxlength="150" disabled></el-input>
      </el-form-item>
      <el-form-item label="用户名:">
        <el-input v-model="detailData.user" class="form-input" maxlength="150" disabled></el-input>
      </el-form-item>
      <el-form-item label="密码:">
        <el-input v-model="detailData.pass" class="form-input" maxlength="150" disabled></el-input>
      </el-form-item>
      <el-form-item label="发件人邮箱:">
        <el-input v-model="detailData.from" class="form-input" maxlength="150" disabled></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <!-- <el-button @click="handleCancel">返回</el-button> -->
      <el-button type="primary" class="button-style" @click="handleCancel">编 辑</el-button>
    </div>
    
  </div>
  <el-dialog title="意见反馈" :visible.sync="suggestionVisible" width="40%" center>
      <el-form ref="form" :model="formData" label-width="10%" size="mini">
        <el-form-item label="标题" required>
          <el-input v-model.trim="formData.title" class="form-input" maxlength="35"></el-input>
        </el-form-item>
        <el-form-item label="内容" required>
          <el-input v-model.trim="formData.content" type="textarea" class="form-input" maxlength="800" show-word-limit rows="5"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" class="button-style" @click="saveEdit">保 存</el-button>
        <el-button type="pain" class="button-style" @click="cancelHandle">取 消</el-button>
      </span>
    </el-dialog>
</div>
  
</template>
<script>
export default {
  data: () => ({
    detailData: []
  }),
  created() {
    this.getDetailData();
  },
  methods: {
    // 获取xianq数据
    // eslint-disable-next-line no-unused-vars
    getDetailData() {
      this.api({
        url: `/product/test/selectProperties`,
        method: "get",
        params: {
          fileName: "email.properties"
        }
      }).then(data => {
        console.log(data);
        this.detailData = data;
      });
    },
    // 取消函数
    handleCancel() {
      this.$router.replace("/homePage/suggestion/");
    }
  }
};
</script>
  <style rel="stylesheet/scss" lang="scss" scoped>
.add-info-whole {
  width: 100%;
  // padding: 10% 0px;
  margin-top: 6%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  .form-input {
    width: 33rem;
  }
  .dialog-footer {
    width: 640px;
    display: contents;
    // flex-direction: column;
    justify-content: space-between;
    align-items: center;
    margin-left: 25%;
  }
  .el-form {
    width: 860px;
  }
}

.button-style {
  margin-left: 10px;
  width: 6rem;
  height: 35px;
}
</style>    
