node{
	stage('SCM Checkout'){
		
		git 'https://gitlab.com/rajkamalsrk/findadoctor.git'
		
	}
	
	stage('Compile-Package'){
		sh 'mvn package'
	}
}