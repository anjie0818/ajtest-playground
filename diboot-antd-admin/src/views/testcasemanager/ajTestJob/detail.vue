<template>
  <a-drawer
    class="detail-wrapper"
    :title="title"
    :width="720"
    @close="close"
    :visible="visible"
    :body-style="{ paddingBottom: '80px' }"
  >
    <a-descriptions :column="2">
      <a-descriptions-item label="任务名称">
        {{ model.name }}
      </a-descriptions-item>
      <a-descriptions-item label="jenkins流水线名称">
        {{ model.jenkinsJobName }}
      </a-descriptions-item>
      <a-descriptions-item label="任务类型">
        {{ model.typeLabel }}
      </a-descriptions-item>
      <a-descriptions-item label="描述">
        {{ model.des }}
      </a-descriptions-item>
    </a-descriptions>
    <a-table
      ref="table"
      size="default"
      :columns="columns"
      :dataSource="model.ajTestJobHistoryList"
      :pagination="false"
      rowKey="id"
    >
    </a-table>

    <div class="drawer-footer">
      <a-button @click="close">关闭</a-button>
    </div>
  </a-drawer>
</template>

<script>
import detail from '@/components/diboot/mixins/detail'

export default {
  name: 'AjTestJobDetail',
  mixins: [detail],
  data () {
    return {
      baseApi: '/ajTestJob',
      columns: [
        {
          title: 'jenkins构建编号',
          dataIndex: 'jenkinsBuildNum'
        },
        {
          title: '执行状态',
          dataIndex: 'executeStatus'
        },
        {
          title: '执行时长',
          dataIndex: 'spendTime'
        },
        {
          title: '创建时间',
          dataIndex: 'createTime'
        },
        {
          title: 'jenkins构建测试报告地址',
          dataIndex: 'jenkinsBuildReportUrl'
        }
  		]
    }
  },
  methods: {
    onAfterOpen () {
      // 事件处理代码
    },
    afterOpen () {
      this.onAfterOpen()
    }
  }
}
</script>
<style lang="less" scoped>
</style>
