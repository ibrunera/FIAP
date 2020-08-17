import React from 'react';

import {SafeAreaView, Text, TextInput, TouchableOpacity} from 'react-native';
import styles from './styles';

const Login = () => {
  return (
    <SafeAreaView style={styles.container}>
      <TextInput style={styles.textoInput} placeholder={'Usuário'} />
      <TextInput
        style={styles.textoInput}
        secureTextEntry={true}
        placeholder={'Senha'}
      />
      <TouchableOpacity onPress={() => alert('Oi')} style={styles.botao}>
        <Text style={styles.botaoTexto}>Login</Text>
      </TouchableOpacity>

      <TouchableOpacity onPress={() => alert('Oi')} style={styles.cadastro}>
        <Text style={styles.cadastroTexto}>Cadastrar-se</Text>
      </TouchableOpacity>
    </SafeAreaView>
  );
};

export default Login;
