<template>
  <a-drawer
    :title="title"
    :width="720"
    @close="close"
    :visible="state.visible"
    :body-style="{ paddingBottom: '80px' }"
  >
    <h3 style="padding: 0 0px; min-height: 50px; line-height: 50px; font-weight: 500; font-size: 20px; text-align: left;">
      jenkins实例配置
    </h3>
    <a-form layout="vertical" :form="form">
      <a-row :gutter="16">
        <a-col :span="12">
          <a-form-item label="jenkins实例名称">
            <a-input
              placeholder="请输入jenkins实例名称"
              v-decorator="[
                'name',
                {
                  initialValue: model.name,
                  rules: [{ required: true, message: 'jenkins实例名称不能为空', whitespace: true }]
                }
              ]"
            />
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="jenkins实例地址">
            <a-input
              placeholder="请输入jenkins实例地址"
              v-decorator="[
                'jenkinsUrl',
                {
                  initialValue: model.jenkinsUrl,
                  rules: [{ required: true, message: 'jenkins实例地址不能为空', whitespace: true }]
                }
              ]"
            />
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="jenkins实例用户">
            <a-input
              placeholder="请输入jenkins实例用户"
              v-decorator="[
                'jenkinsUsername',
                {
                  initialValue: model.jenkinsUsername,
                  rules: [{ required: true, message: 'jenkins实例用户不能为空', whitespace: true }]
                }
              ]"
            />
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="jenkins实例用户token">
            <a-input
              placeholder="请输入jenkins实例用户token"
              v-decorator="[
                'jenkinsToken',
                {
                  initialValue: model.jenkinsToken,
                  rules: [{ required: true, message: 'jenkins实例用户token不能为空', whitespace: true }]
                }
              ]"
            />
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="备注">
            <a-textarea
              placeholder="请输入备注"
              v-decorator="[
                'remarks',
                {
                  initialValue: model.remarks
                }
              ]"
            />
          </a-form-item>
        </a-col>
      </a-row>
    </a-form>
    <div class="drawer-footer">
      <a-button @click="close">取消</a-button>
      <a-button @click="onSubmit" type="primary" :loading="state.confirmSubmit" :disabled="state.confirmSubmit">确定</a-button>
    </div>
  </a-drawer>
</template>

<script>
import form from '@/components/diboot/mixins/form'

export default {
  name: 'AjJenkinsForm',
  mixins: [form],
  data () {
    return {
      baseApi: '/ajJenkins',
      form: this.$form.createForm(this)
    }
  }
}
</script>
<style lang="less" scoped>
</style>
