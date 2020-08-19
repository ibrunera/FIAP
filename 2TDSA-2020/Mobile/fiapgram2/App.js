import React from 'react';
import { NavigationContainer, StackActions } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';

import Cadastro from './src/screens/Cadastro'
import Login from './src/screens/Login'
import Main from './src/screens/Main'

const Stack = createStackNavigator();

const App=  (props) => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Login" component={ Login} options={{headerShown:false}}/>
        <Stack.Screen name="Cadastro" component={ Cadastro} />
        <Stack.Screen name="Main" component={ Main} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;
