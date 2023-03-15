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
      <a-descriptions-item label="系统名称">
        {{ model.name }}
      </a-descriptions-item>
      <a-descriptions-item label="描述">
        {{ model.des }}
      </a-descriptions-item>
      <a-descriptions-item label="创建时间">
        {{ model.createTime }}
      </a-descriptions-item>
      <a-descriptions-item label="更新时间">
        {{ model.updateTime }}
      </a-descriptions-item>
      <a-descriptions-item label="创建人">
        {{ model.createByName }}
      </a-descriptions-item>
      <a-descriptions-item label="更新人">
        {{ model.updateByName }}
      </a-descriptions-item>
    </a-descriptions>
    <a-table
      ref="table"
      size="default"
      :columns="columns"
      :dataSource="model.ajTestJobList"
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
  name: 'AjSystemDetail',
  mixins: [detail],
  data () {
    return {
      baseApi: '/ajSystem',
      columns: [
        {
          title: '任务名称',
          dataIndex: 'name'
        },
        {
          title: '任务类型',
          dataIndex: 'des'
        },
        {
          title: '模式',
          dataIndex: 'jenkinsJobName'
        },
        {
          title: '执行脚本',
          dataIndex: 'jenkinsFile'
        },
        {
          title: '描述',
          dataIndex: 'createTime'
        },
        {
          title: '创建时间',
          dataIndex: 'updateTime'
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
