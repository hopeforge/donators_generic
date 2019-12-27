const constraints = {
  video: {
    facingMode: { ideal: 'environment' }
  }
};

const camera = document.querySelector('#camera');
const preview = document.querySelector('#preview');
const player = document.querySelector('#player');
const canvas = document.querySelector('canvas');
const btnTakePicture = document.querySelector('#btn-tirar-foto');
const btnEnviar = document.querySelector('#btn-enviar-foto');
const btnCancelar = document.querySelector('#btn-cancelar-envio');
let videoTracks;

const handleSuccess = (stream) => {
  player.srcObject = stream;
  videoTracks = stream.getVideoTracks();
};

const handleError = (stream) => {
  console.log(stream + 'dkapsodkapos');
};

const toggleView = (sectionMostrar, sectionEsconder, disp) => {
  sectionEsconder.style.display = 'none';
  sectionMostrar.style.display = disp;
};

const enviarFoto = async (fotoCapturada) => {
  let dataObj = {
    file: fotoCapturada,
    email: 'walvesa@indracompany.com'
  };

  // await axios.post('https://172.31.15.21:8080/cupom/uploadFile', dataObj)
  //   .then(response => {
  //     console.log('enviado com sucesso');
  //     console.log(response);
  //   })
  //   .catch(error => {
  //     console.log(error);
  //   });

  var ajax = new XMLHttpRequest();

  ajax.open("POST", "http://172.31.15.21:8080/cupom/uploadFile", true);
  ajax.setRequestHeader("Content-type", "multipart/form-data");

  ajax.send(dataObj);

  ajax.onreadystatechange = () => {
    if (ajax.readyState == 4 && ajax.status == 200) {
      var data = ajax.responseText;
      console.log(data);
    }
  }
};

btnTakePicture.addEventListener('click', () => {
  const context = canvas.getContext('2d');
  context.drawImage(player, 0, 0, canvas.width, canvas.height);
  toggleView(preview, camera, 'block');
  videoTracks.forEach(function (track) {
    track.stop()
  });
});

const obterPermissaoCamera = () => {
  if (navigator.mediaDevices === undefined || navigator.mediaDevices.getUserMedia === undefined) {
    navigator.mediaDevices.getUserMedia = function (constraints) {

      var getUserMedia = navigator.webkitGetUserMedia || navigator.mozGetUserMedia;

      if (!getUserMedia) {
        return Promise.reject(new Error('getUserMedia is not implemented in this browser'));
      }

      return new Promise(function (resolve, reject) {
        getUserMedia.call(navigator, constraints, resolve, reject);
      });
    }
  }

  navigator.mediaDevices.getUserMedia(constraints)
    .then(function (stream) {
      var video = document.querySelector('video');
      if ("srcObject" in video) {
        video.srcObject = stream;
      } else {
        video.src = window.URL.createObjectURL(stream);
      }
      video.onloadedmetadata = function (e) {
        video.play();
      };
    })
    .catch(function (err) {
      console.log(err.name + ": " + err.message);
    });

};

const dataURLtoFile = (dataurl, filename) => {

  var arr = dataurl.split(','),
    mime = arr[0].match(/:(.*?);/)[1],
    bstr = atob(arr[1]),
    n = bstr.length,
    u8arr = new Uint8Array(n);

  while (n--) {
    u8arr[n] = bstr.charCodeAt(n);
  }

  return new File([u8arr], filename, { type: mime });
};

btnEnviar.addEventListener('click', () => {
  let arquivo = dataURLtoFile(canvas.toDataURL("image/png"), 'cupom');
  enviarFoto(arquivo);
  alert('Obrigado!');
  toggleView(camera, preview, 'flex');
  obterPermissaoCamera();
});

btnCancelar.addEventListener('click', () => {
  toggleView(camera, preview, 'flex');
  obterPermissaoCamera();
});

obterPermissaoCamera();






