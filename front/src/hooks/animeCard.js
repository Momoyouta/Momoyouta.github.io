export function tranToCard(data){
    let anilist=[];
    for(let item of data){
        let anttp={
            show:{
                score: false,
                state: true,
                date: true,
                name: true
            },
            data: {
                id:item.id,
                name:item.name,
                image:item.image,
                ep:item.ep,
                end:item.end,
                updateTime:item.updateTime,
            }
        }
        let date=anttp.data.updateTime.split("-");
        anttp.data.updateTime=date[1]+'/'+date[2].split("T")[0]
        anilist.push(anttp);
    }
    return anilist;
}