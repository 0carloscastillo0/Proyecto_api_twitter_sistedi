<template>
  <div class="card">
    <div class="card-header pb-0">
      <h6>Tweets</h6>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table p-0">
        <table class="table align-items-center mb-0">
          <thead>
            <tr>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Usuario</th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >Tweet</th>
              <th
                class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
              >
                <p class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Retweets</p>
                <p class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Favoritos</p>
              </th>
              <th
                class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
              >Fecha</th>
              <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                Ubicacion
              </th>
            </tr>
          </thead>
          
          <tbody >
            <tr  v-for="tweet in tweets" v-bind:key = "tweet.id">
              <td>
                <div class="d-flex px-2 py-1">
                  <div class="d-flex flex-column justify-content-center">
                    <h6 class="mb-0 text-sm">{{tweet.user}}</h6>
                  </div>
                </div>
              </td>
              <td >
                <div style="width: 300px;overflow-y: scroll;overflow-wrap: break-word;">
                  <p class="text-xs font-weight-bold mb-0">{{tweet.text}}</p>
                </div>
              </td>
              <td class="align-middle text-center text-sm">
                <p class="text-xs font-weight-bold mb-0">{{tweet.retweets}}</p>
                <p class="text-xs text-secondary mb-0">{{tweet.favoritos}}</p>
              </td>
              <td class="align-middle text-center">
                <span class="text-secondary text-xs font-weight-bold">{{tweet.created_at}}</span>
              </td>
              <td class="align-middle text-center">
                <span class="text-secondary text-xs font-weight-bold">{{tweet.place}}</span>
              </td>
            </tr>
            
            
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>



<script>
import axios from 'axios'
export default {
    name: "projects-table",
    data() {
    return {
      tweets: []
      }
    },
    async mounted() {
      await axios.get('http://127.0.0.1:4444/tweets/all').then((response) => {
        console.log(this.tweets=response.data)
      })
    }
    
}
</script>
