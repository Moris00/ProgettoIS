/**
 * 
 */
//Gestione della compatibilità
function getXmlHttpRequest(){
	
	var xhr = false;
	var activeXoptions = new Array("Microsoft.XmlHttp", "MSXML4.XmlHttp", "MSXML3.XmlHttp", "MSXML2.XmlHttp", "MSXML.XmlHttp");
	
	try{
		xhr = new XMLHttpRequest();
	}catch(e){
		
	}
	
	if(!xhr){
		var created = false;
		for(var i = 0; i < activeXoptions.length && !created; i++){
			try{
				xhr = new ActiveXObject(activeXoptions[i]);
				created = true;
			}catch(e){}
		}
	}
}

function wait(state){
	if(state == true){
		//Show wait
		alert("Aaspettam");
	}else{
		//Hide wait
		alert("Fine aspettamm");
	}
}

function getReadyStateHandler(req, responseXmlHandler, id){
	return function(){
		if(req.readyState == 1){
			console.log("Server connection");
		}else if(req.readyState == 4){
			if(req.status == 200 || req.status == 304){
				responseXmlHandler(req.responseXML, id);
			}else{
				//window.alert("")
			}
		}else{
			wait(false);
		}
	}
}

function deleteAjaxCall(id, url, callback, parameter){
	
	
	var req = new XMLHttpRequest;
	try{
		wait(true);
		
		req.onreadystatechange = getReadyStateHandler(req, callback, id);

		req.open('POST', url, true);
		req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		req.send("name_product=" + parameter);
	}catch(e1){
		alert(e1);
		wait(false);
	}
	
}





