<template>
  <div class="card">
    <div class="card-header pb-0">
      <h6>Authors table</h6>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center mb-0">
          <thead>
            <tr>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Tweets totales</th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >Media Retweets</th>
              <th
                class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
              >Varianza Retweets</th>
              <th
                class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
              >Media Favoritos</th>
              <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
              >Varianza Favoritos
              </th>
            </tr>
          </thead>
          <tbody >
            <tr>
              <td>
                <div class="d-flex px-2 py-1">
                  <div class="d-flex flex-column justify-content-center">
                    <h6 class="mb-0 text-sm">{{count}}</h6>
                  </div>
                </div>
              </td>
              <td >
                <div style="width: 300px;overflow-y: scroll;overflow-wrap: break-word;">
                  <p class="text-xs font-weight-bold mb-0">{{mediaRet}}</p>
                </div>
              </td>
              <td class="align-middle text-center text-sm">
                <p class="text-xs font-weight-bold mb-0">{{varRet}}</p>
              </td>
              <td class="align-middle text-center">
                <span class="text-secondary text-xs font-weight-bold">{{mediaFav}}</span>
              </td>
              <td class="align-middle text-center">
                <span class="text-secondary text-xs font-weight-bold">{{varFav}}</span>
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
  name: "authors-table",
  data() {
    return {
      count:0,
      mediaRet:0,
      varRet:0,
      mediaFav:0,
      varFav:0
      }
    },
    async mounted() {
      await axios.get('http://127.0.0.1:4444/tweets/countTweets').then((response) => {console.log(this.count=response.data)}),
      await axios.get('http://127.0.0.1:4444/tweets/meanFav').then((response) => {console.log(this.mediaFav=response.data)}),
      await axios.get('http://127.0.0.1:4444/tweets/varFav').then((response) => {console.log(this.varFav=response.data)}),
      await axios.get('http://127.0.0.1:4444/tweets/meanRet').then((response) => {console.log(this.mediaRet=response.data)}),
      await axios.get('http://127.0.0.1:4444/tweets/varRet').then((response) => {console.log(this.varRet=response.data)})
    }
};
</script>
