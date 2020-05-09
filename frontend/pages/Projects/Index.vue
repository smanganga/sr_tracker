<template>
  <div>
    <Project
      v-for="project in projects"
      :id="project.id"
      :key="project.id"
      :title ="project.title"
      :description="project.description"
      :location="project.location"
    />
  </div>
</template>
<script>
import axios from 'axios'
import Project from '../../components/Project'

export default {
  components: {
    Project
  },
  data () {
    return {
      projects: []
    }
  },
  async created () {
    const config = {
      headers: {
        Accept: 'application/json'
      }
    }
    try {
      const res = await axios.get('http://localhost:8080/api/projects', config)
      this.projects = res.data
    } catch (e) {
      console.log(e)
    }
  },
  head () {
    return {
      title: 'Projects Page',
      meta: [
        {
          hid: 'description',
          name: 'description',
          content: 'Best website for social responsibility tracking'
        }
      ]
    }
  }
}
</script>
