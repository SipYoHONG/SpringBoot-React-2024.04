import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../App.css';

export default function App() {
    const [users, setUsers] = useState([]);
    const [isLoding, setIsLoding] = useState(true);
    useEffect(() => {
        axios.get('/rp/react/users')
            .then(res => {
                console.log(res.data);
                setUsers(res.data);
                setIsLoding(false);
            })
            .catch(error => {console.log(error);});
    }, []);

return (
    <div>
      <h2>사용자 목록</h2>
      <h3>{isLoding ? '로딩중...' : ''}</h3>
      <table border={1}>
      <tr>
        <th>uid</th><th>uname</th><th>이메일</th><th>등록일</th>
        <th>사진</th><th>깃허브</th><th>인스타</th><th>지역</th>
      </tr>
      {
        users.map(user => (
            <tr key={user.uid}>
                <td>{user.uid}</td><td>{user.uname}</td>
                <td>{user.email}</td><td>{user.regDate}</td>
                <td>{user.profile}</td><td>{user.github}</td>
                <td>{user.insta}</td><td>{user.location}</td>
            </tr>
        ))
      }
      </table>
    </div>
  );
}