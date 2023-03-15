<template>
  <a-drawer
    class="detail-wrapper"
    :title="title"
    :width="720"
    @close="close"
    :visible="visible"
    :body-style="{ paddingBottom: '80px' }"
  >
    <a-descriptions :column="1">
      <a-descriptions-item label="jenkins实例名称">
        {{ model.name }}
      </a-descriptions-item>
      <a-descriptions-item label="jenkins实例地址">
        {{ model.jenkinsUrl }}
      </a-descriptions-item>
      <a-descriptions-item label="jenkins实例用户">
        {{ model.jenkinsUsername }}
      </a-descriptions-item>
      <a-descriptions-item label="jenkins实例用户token">
        {{ model.jenkinsToken }}
      </a-descriptions-item>
      <a-descriptions-item label="备注">
        {{ model.remarks }}
      </a-descriptions-item>
      <a-descriptions-item label="创建时间">
        {{ model.createTime }}
      </a-descriptions-item>
    </a-descriptions>
    <div class="drawer-footer">
      <a-button @click="close">关闭</a-button>
    </div>
  </a-drawer>
</template>

<script>
import detail from '@/components/diboot/mixins/detail'

export default {
  name: 'AjJenkinsDetail',
  mixins: [detail],
  data () {
    return {
      baseApi: '/ajJenkins'
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
