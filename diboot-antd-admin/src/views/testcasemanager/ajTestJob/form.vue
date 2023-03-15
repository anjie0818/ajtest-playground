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
          <a-form-item label="任务名称">
            <a-input
              placeholder="请输入任务名称"
              v-decorator="[
                'name',
                {
                  initialValue: model.name,
                  rules: [{ required: true, message: '任务名称不能为空', whitespace: true }]
                }
              ]"
            />
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="归属项目">
            <a-select
              :filter-option="filterOption"
              show-search
              :getPopupContainer="getPopupContainer"
              placeholder="请选择归属项目"
              allowClear
              v-decorator="[
                'systemId',
                {
                  initialValue: model.systemId ? `${model.systemId}` : ''
                }
              ]"
            >

              <a-select-option
                value=""
              >

                -- 请选择 --
              </a-select-option>
              <a-select-option
                v-for="(item, index) in more.ajSystemOptions"
                :key="index"
                :value="`${item.value}`"
              >
                {{ item.label }}
              </a-select-option>
            </a-select>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="任务类型">
            <a-select
              show-search
              :filter-option="filterOption"
              :getPopupContainer="getPopupContainer"
              placeholder="请选择"
              allowClear
              v-decorator="[
                'type',
                {
                  initialValue: model.type
                }
              ]"
            >
              <a-select-option
                value=""
              >
                -- 请选择 --
              </a-select-option>
              <a-select-option
                v-for="(item, index) in more.testTypeOptions"
                :key="index"
                :value="item.value"
              >
                {{ item.label }}
              </a-select-option>
            </a-select>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="模式">
            <a-select
              show-search
              :filter-option="filterOption"
              :getPopupContainer="getPopupContainer"
              placeholder="请选择"
              allowClear
              v-decorator="[
                'mode',
                {
                  initialValue: model.mode
                }
              ]"
            >
              <a-select-option
                value=""
              >
                -- 请选择 --
              </a-select-option>
              <a-select-option
                v-for="(item, index) in more.testModeOptions"
                :key="index"
                :value="item.value"
              >
                {{ item.label }}
              </a-select-option>
            </a-select>
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
        <a-col :span="12">
          <a-form-item label="jenkins流水线名称">
            <a-input
              placeholder="请输入jenkins流水线名称"
              v-decorator="[
                'jenkinsJobName',
                {
                  initialValue: model.jenkinsJobName
                }
              ]"
            />
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="执行引擎">
            <a-select
              :filter-option="filterOption"
              show-search
              :getPopupContainer="getPopupContainer"
              placeholder="请选择执行引擎"
              allowClear
              v-decorator="[
                'jenkinsId',
                {
                  initialValue: model.jenkinsId ? `${model.jenkinsId}` : ''
                }
              ]"
            >

              <a-select-option
                value=""
              >

                -- 请选择 --
              </a-select-option>
              <a-select-option
                v-for="(item, index) in more.ajJenkinsOptions"
                :key="index"
                :value="`${item.value}`"
              >
                {{ item.label }}
              </a-select-option>
            </a-select>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="执行脚本">
            <a-textarea
              placeholder="请输入执行脚本"
              v-decorator="[
                'jenkinsFile',
                {
                  initialValue: model.jenkinsFile
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
  name: 'AjTestJobForm',
  mixins: [form],
  data () {
    return {
      baseApi: '/ajTestJob',
      form: this.$form.createForm(this),
      attachMoreList: [
        {
          target: 'AjSystem',
          label: 'name',
          value: 'id'
        },
        {
          target: 'TEST_TYPE'
        },
        {
          target: 'TEST_MODE'
        },
        {
          target: 'AjJenkins',
          label: 'name',
          value: 'id'
        }
      ]
    }
  }
}
</script>
<style lang="less" scoped>
</style>
