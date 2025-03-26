export function throttle(fn,delay){
    let timer = null;
    return (...args)=>{
        if(!timer){
            timer=setTimeout(()=>{
                fn.apply(this,args);
                timer = null;
            },delay)
        }
    }
}

export function checkScroll(callback){
    const scrollTop=window.scrollY;
    const clientHeight=window.innerHeight;
    const scrollHeight =document.documentElement.scrollHeight;
    if(Math.ceil(scrollTop+clientHeight)>=scrollHeight){
        callback(1);
    }
}