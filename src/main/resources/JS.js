// fetch('https://jsonplaceholder.typicode.com/users/12')
// .then(res => {
//     //console.log(res)
//     if (res.status >= 400){
//         const error = new Error(`Error ${res.status} ${res.statusText}`)
//         throw error
//     }
//     return res.json()
// })
// .then( body => {
//     console.log(body)
// })
// .catch(err =>{
//     //console.log(err)
//     console.log(err.message)
// })

async function asyncAwaitDemo(){
    try{
        const res = await fetch('https://jsonplaceholder.typicode.com/users/2222222')
        if (res.status >= 400){
            const error = new Error(`Error ${res.status} ${res.statusText}`)
            throw error
        }
        const body = await res.json()
        console.log(body)
    }
    catch(err){
        console.log(err.message)
    }
}

asyncAwaitDemo()