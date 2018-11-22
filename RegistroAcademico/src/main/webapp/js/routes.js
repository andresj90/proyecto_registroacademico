var app = angular.module('RegistroAcademico');

app.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) { 
       
        //Otherwise - control 404
        $urlRouterProvider.otherwise('/');
        
        //Por cada ruta se crea un nuevo estado

        
         $stateProvider.state("crearActualizarHorario", {
           url: '/horario' ,
           views:{
               mainView: {
                   templateUrl: 'js/horario/crearActualizar/CrearHorario.html',
                   controller: 'horarioCtrl'
               }
           }
        });
        

        
        $stateProvider.state("listarHorarios", {
           url: '/' ,
           views:{
               mainView: {
                   templateUrl: 'js/horario/listar/ListarHorario.html',
                   controller: 'listarHorarioCtrl'
               }
           }
        });
        
        
        $stateProvider.state("editarHorarios", {
           url: '/horarios/:id' ,
           views: {
               
               mainView :{
                  templateUrl: 'js/horario/crearActualizar/CrearHorario.html',
                  controller : 'horarioCtrl' 
               
               }
           }
            
        }); 
        
        
        
        //routes for docente 
      
                
        $stateProvider.state("registrarCoordinador", {
           url: '/coordinador' ,
           views: {
               
               mainView :{
                  templateUrl: 'js/coordinador/crearActualizar/registrarCoordinador.html',
                  controller : 'coordinadorCtrl' 
               
               }
           }
            
        }); 
        
        
        

         $stateProvider.state("crearActualizarTipoCurso", {
           url: '/tipoCurso' ,
           views:{
               mainView: {
                   templateUrl: 'js/tipoCurso/crearActualizar/CrearTipoCurso.html',
                   controller: 'crearTipoCursoCtrl'
               }
           }
        });
        
        $stateProvider.state("listarTipoCurso", {
           url: '/listarTipoCurso' ,
           views:{
               mainView: {
                   templateUrl: 'js/tipoCurso/listar/ListarTipoCurso.html',
                   controller: 'listarTipoCursoCtrl'
               }
           }
        });
}]); 