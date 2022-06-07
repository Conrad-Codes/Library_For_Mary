import axios from 'axios';

export default {

    getAllTopics(){
        return axios.get('/forum');
    },

    getPostsByTopicId(topicId){
        return axios.get(`/forum/${topicId}`)
    }

}