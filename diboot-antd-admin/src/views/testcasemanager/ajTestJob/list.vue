<template>
  <a-card :bordered="false">
    <div class="table-page-search-wrapper">
      <a-form layout="inline" :labelCol="{span: 6}" :wrapperCol="{span: 18}">
        <a-row :gutter="18">
          <a-col :md="8" :sm="24">
            <a-form-item label="任务名称" >
              <a-input @keyup.enter.native="onSearch" v-model="queryParam.name" placeholder="" allowClear/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="归属项目">
              <a-select
                allowClear
                @change="onSearch"
                :getPopupContainer="getPopupContainer"
                placeholder="请选择归属项目"
                v-model="queryParam.systemId"
              >

                <a-select-option
                  v-for="(item, index) in more.ajSystemOptions || []"
                  :key="index"
                  :value="item.value"
                >
                  {{ item.label }}
                </a-select-option>
              </a-select>
            </a-form-item>
          </a-col>
          <template v-if="advanced">
            <a-col :md="8" :sm="24">
              <a-form-item label="任务类型">
                <a-select @change="onSearch" v-model="queryParam.type" placeholder="请选择任务类型" allowClear>
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
            <a-col :md="8" :sm="24">
              <a-form-item label="模式">
                <a-select @change="onSearch" v-model="queryParam.mode" placeholder="请选择模式" allowClear>
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
          </template>
          <a-col :md="!advanced && 8 || 24" :sm="24">
            <span class="table-page-search-submitButtons" :style="advanced && { float: 'right', overflow: 'hidden' } || {} ">
              <a-button type="primary" @click="onSearch">查询</a-button>
              <a-button @click="reset">重置</a-button>
              <a @click="toggleAdvanced">
                {{ advanced ? '收起' : '展开' }}
                <a-icon :type="advanced ? 'up' : 'down'"/>
              </a>
            </span>
          </a-col>
        </a-row>
      </a-form>
    </div>

    <div class="table-operator">
      <a-button v-action:create type="primary" icon="plus" @click="$refs.form.open()">新建</a-button>
    </div>

    <div class="table-operator" style="text-align: left;">
    </div>

    <a-table
      ref="table"
      size="default"
      :columns="columns"
      :dataSource="data"
      :pagination="pagination"
      :scroll="tableScrollData"
      :loading="loadingData"
      @change="handleTableChange"
      rowKey="id"
    >
      <span slot="action" slot-scope="text, record">
        <a v-action:detail href="javascript:;" @click="buildJob(record.id)">触发</a>
        <a v-action:detail href="javascript:;" @click="$refs.detail.open(record.id)">执行历史</a>
        <a-divider v-action:detail v-permission="['update', 'delete']" type="vertical" />
        <a-dropdown v-permission="['update', 'delete']">
          <a class="ant-dropdown-link">
            更多 <a-icon type="down"/>
          </a>
          <a-menu slot="overlay">
            <a-menu-item v-action:update>
              <a @click="$refs.form.open(record.id)">编辑</a>
            </a-menu-item>
            <a-menu-item v-action:delete>
              <a @click="remove(record.id)">删除</a>
            </a-menu-item>
          </a-menu>
        </a-dropdown>
      </span>
    </a-table>
    <diboot-form ref="form" @complete="getList"></diboot-form>
    <diboot-detail ref="detail"></diboot-detail>
  </a-card>
</template>

<script>
import list from '@/components/diboot/mixins/list'
import dibootForm from './form'
import dibootDetail from './detail'
import { dibootApi } from '@/utils/request'
export default {
  name: 'AjTestJobList',
  components: {
    dibootForm,
    dibootDetail
  },
  mixins: [list],
  data () {
    return {
      baseApi: '/ajTestJob',
      getListFromMixin: true,
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
        }
      ],
      columns: [
        {
          title: '任务名称',
          dataIndex: 'name' },
        {
          title: '归属项目',
          dataIndex: 'ajSystemName' },
        {
          title: '模式',
          dataIndex: 'modeLabel' },
        {
          title: '任务类型',
          dataIndex: 'typeLabel' },
        {
          title: '创建人',
          dataIndex: 'createByName' },
        {
          title: '创建时间',
          dataIndex: 'createTime' },
        {
          title: '更新人',
          dataIndex: 'updateByName' },
        {
          title: '更新时间',
          dataIndex: 'updateTime' },
        {
          title: '操作',
          width: '150px',
          fixed: 'right',
          dataIndex: 'action',
          scopedSlots: { customRender: 'action' }
        }
      ]
    }
  },
  methods: {
    async buildJob (id) {
      const res = await dibootApi.get(`${this.baseApi}/buildJob/${id}`)
      if (res.code === 0) {
        alert(res.data)
      } else {
        this.$notification.error({
          message: '触发失败',
          description: res.msg
        })
      }
    }
  }
}
</script>
<style lang="less" scoped>
</style>
