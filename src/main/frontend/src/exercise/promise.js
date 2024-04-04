// 1. Producer
const promise = new Promise((resovle, reject) => {
    // 네트워크 작업, 파일 작업 등으로 시간이 소요되는 작업!
    console.log('Doing something...');
    setTimeout(() => {
        // resovle('작업 결과');
        reject(new Error('error 발생'));
    }, 2000);
});

// 2. Consumer
promise
    .then(value => {
        console.log(value);
})
.catch(error => {
    console.log(error);
});