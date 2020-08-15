

pipeline {
    agent {

            node { label 'master' }

    }
    stages {
        stage ('stage 1 : Execute Terraform to create VM on AWS') {
            steps {
                set_env_variables ()
                dir ("D:\\Git\\jenkins\\src\\applyaws\\terraform\\") {
                    powershell '''
                    echo "***Setting up personal access in local laptop ***"
                    .\\AWS_Myperssonal.ps1
                    '''
                    powershell '''
                    echo "***Initiate Terraform ***"
                    .\\terraform.exe init
                    '''
                    powershell '''
                    echo "**Terraform Plan ***"
                    .\\terraform.exe plan
                    '''
                }
            }
        }
    }
}

def set_env_variables () {
    env.PIPELINE_NODE = "${env.NODE_NAME}"
    env.PIPELINE_WS = "${env.WORKSPACE}"
}