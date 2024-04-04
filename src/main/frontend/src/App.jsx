import React, { useEffect, useState } from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

export default function App() {
  const [data, setData] = useState('');
  const [user, setUser] = useState({});
  // useEffect(() => {
  //   axios.get('/rp/react/data')
  //     .then(res => {
  //       console.log(res);
  //       setData(res.data);
  //     })
  //     .catch(error => {console.log(error);});
  // }, []);
  useEffect(() => {
    axios.get('/rp/react/json')
      .then(res => setUser(res.data))
      .catch(error => console.log(error));
  }, []);
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h3>
          받아온 값: {data ? data : '받아오지 못했습니다.'}  
        </h3> 
        <h3>
          사용자 정보: uid={user.uid}, uname={user.uname}
        </h3>
      </header>
    </div>
  );
}

