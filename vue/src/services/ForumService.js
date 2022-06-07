import axios from 'axios';

export default {

    getAllTopics(){
        return axios.get('/forum');
    },

    getPostsByTopicId(topicId){
        return axios.get(`/forum/${topicId}`)
    },

    createTopic(topic){
        return axios.post('/forum/add-forum-topic', topic)
    },

    createReply(reply){
        return axios.post("/forum/topic/add-post", reply)
    }

}