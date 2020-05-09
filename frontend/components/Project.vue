<template>
  <div class="project">
    <table>
      <tr>
        <td>{{ id }}</td>
        <td>{{ title }}</td>
        <td>{{ description }}</td>
        <td>{{ location }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'Project',
  props: ['location', 'description', 'id', 'title']
}
</script>

<style>
  .project {
    padding: 1rem;
    border: 1px dotted #cccccc;
    margin: 1rem 0;
  }
</style>
