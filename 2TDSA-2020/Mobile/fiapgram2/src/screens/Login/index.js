import React from 'react';
import {SafeAreaView, Text, TouchableOpacity} from 'react-native';

import { Button, Input } from 'react-native-elements';

const Login = () => {
    return(
        <SafeAreaView>
            <Input/>
            <Input/>
            <Button title="Login"/>

            <TouchableOpacity onPress={()=>alert('Clicou')}>
                <Text>Cadastre-se</Text>
            </TouchableOpacity>
        </SafeAreaView>
    );
}

export default Login;