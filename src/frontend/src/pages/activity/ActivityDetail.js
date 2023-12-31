import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const ActivityDetail = () => {
  const [activity, setActivity] = useState({
    id: '',
    title: '',
    contents: '',
    currentCnt: '',
    projectStatus: '',
    createAt: '',
    createBy: '',
    state: '',
    object: '',
    goalCnt: '',
    deadLine: ''
  });
  const { activity_id } = useParams(); // Destructure the parameter directly
  console.log(activity_id);

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/activity/${activity_id}`)
      .then(response => {
        const responseData = response.data; // Destructure the response data
        const activityForm = {
          id: responseData.id,
          title: responseData.title,
          contents: responseData.contents,
          currentCnt: responseData.currentCnt, // Correct typo "curruntCnt" to "currentCnt"
          projectStatus: responseData.projectStatus,
          createAt: responseData.createAt,
          createBy: responseData.createBy,
          state: responseData.state,
          object: responseData.object,
          goalCnt: responseData.goalCnt,
          deadLine: responseData.deadLine
        };
        setActivity(activityForm);
        console.log(activityForm);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, [activity_id]); // Add activity_id as a dependency to useEffect

  return (
    <div>
      <h1>{activity.title}</h1>
    </div>
  );
};

export default ActivityDetail;
