<template>
  <a-drawer
    :title="title"
    :width="720"
    @close="close"
    :visible="state.visible"
    :body-style="{ paddingBottom: '80px' }"
  >
    <a-form layout="vertical" :form="form">
      <a-row :gutter="16">
        <a-col :span="12">
          <a-form-item label="系统名称">
            <a-input
              placeholder="请输入系统名称"
              v-decorator="[
                'name',
                {
                  initialValue: model.name
                }
              ]"
            />
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="描述">
            <a-textarea
              placeholder="请输入描述"
              v-decorator="[
                'des',
                {
                  initialValue: model.des
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
  name: 'AjSystemForm',
  mixins: [form],
  data () {
    return {
      baseApi: '/ajSystem',
      form: this.$form.createForm(this)
    }
  }
}
</script>
<style lang="less" scoped>
</style>
