import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Footer from '../common/Footer';
import Header from '../common/Header';
import NotFound from '../common/NotFound';
import '../css/App.css';
import Main from '../pages/Main';
import FundingList from '../pages/funding/FundingList';
import FundingCreate from '../pages/funding/FundingCreate';
import FundingDetails from '../pages/funding/FundingDetails';
import ActivityDetail from '../pages/activity/ActivityDetail';
import ActivityList from '../pages/activity/ActivityList';
import ActivityCreate from '../pages/activity/ActivityCreate';

const App = () => {
  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<Main />}></Route>
        <Route path="/project/funding/list" element={<FundingList />}></Route>
        <Route
          path="/project/funding/create"
          element={<FundingCreate />}
        ></Route>
        <Route
          path="/project/funding/details/:funding_id"
          element={<FundingDetails />}
        ></Route>
        <Route
          path="/project/funding/edit/:funding_id"
          element={<FundingDetails />}
        ></Route>
        <Route
          path="/activity/detail/:activity_id"
          element={<ActivityDetail />}
        ></Route>
        <Route path="/activity" element={<ActivityList />}></Route>
        <Route path="/activity/create" element={<ActivityCreate />}></Route>
        {/* 없는 페이지 처리 */}
        <Route path="*" element={<NotFound />}></Route>
      </Routes>
      <Footer />
    </div>
  );
};

export default App;
