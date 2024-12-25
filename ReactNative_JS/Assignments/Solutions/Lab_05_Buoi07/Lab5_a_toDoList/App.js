import React, { useState } from 'react';
import {
  View,
  Text,
  Image,
  TextInput,
  TouchableOpacity,
} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';
import Icon1 from 'react-native-vector-icons/MaterialIcons';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import styles from './components/home/homeStyle';
import sTask from './components/home/TaskStyle';
import sAdd from './components/home/AddStyle';
//Trang 1
const Home = ({ navigation }) => {
  const [searchQuery, setSearchQuery] = useState('');
  return (
    <View style={{ flex: 1, padding: 20, backgroundColor: 'white' }}>
      <View style={styles.header}>
        <Image source={require('./assets/Image95.png')} />
      </View>

      <View style={styles.center}>
        <Text style={styles.textTitle}>MANGAGE YOUR TASK</Text>
        <View style={styles.inputText}>
          <Icon
            name="search"
            size={20}
            color="#000"
            style={{ marginRight: 5 }}
          />
          <TextInput
            style={styles.input}
            placeholder="Enter your name"
            placeholderTextColor="#888"
            value={searchQuery}
            onChangeText={(text) => setSearchQuery(text)}
          />
        </View>
      </View>
      <View style={styles.footer}>
        <TouchableOpacity
          style={styles.button}
          onPress={() => navigation.navigate('Task')}>
          <Text style={styles.buttonText}>GET STARTED -></Text>
        </TouchableOpacity>
      </View>
    </View>
  );
};
//Trang 2
const Task = ({route, navigation}) => {

  const [taskJob, setTaskJob] = useState('');
  const [array, setArray] = useState([]);

  const arrayTask = (taskJob) => {
    setArray([...array, taskJob]);
  }

  return (
    <View style={{ flex: 1, padding: 10}}>
      <View style={sTask.header}>
        <View style={sTask.title}>
          <Image
            source={require('./assets/Rectangle.png')}
            style={{ with: 45, height: 45, borderRadius: 100 }}
          />
          <View style={sTask.text}>
            <Text style={sTask.hi}>Hi Twinkle</Text>
            <Text>Have agrate day a head </Text>
          </View>
        </View>
        <View style={sTask.inputText}>
          <Icon
            name="search"
            size={20}
            color="#000"
            style={{ marginRight: 5 }}
          />
          <TextInput
            style={styles.input}
            placeholder="Search"
            placeholderTextColor="#888"
          />
        </View>
      </View>
      <View style={sTask.center}>
          
          {
             array.map((item, index) =>{
                return (
                   <View style={sTask.task}> 
                   <Text>{item}</Text>
                   <TouchableOpacity>
                          <Icon1 name="edit" size={24} color="red" />
                   </TouchableOpacity>
                   </View>
                );
             })
          }
      </View>
      <View style={sTask.footer}>
          <TouchableOpacity style={sTask.button}
                           onPress={() => navigation.navigate('Add',
                                         { onAddTask:arrayTask})
                                    }
          >
                <Text style={sTask.buttonText}>+</Text>
          </TouchableOpacity>
      </View>
    </View>
  );
};
//Trang 3
const Add = ({route, navigation }) => {
  const [searchQuery, setSearchQuery] = useState('');
  

  const addTask = () => {
     if(searchQuery.length === 0){
        alert("Vui lòng nhập công việc!");
        return;
     }
     if (route.params?.onAddTask) {
           route.params.onAddTask(searchQuery); 
     }
     navigation.goBack(); 
  };

  return (
    <View style={{ flex: 1, padding: 15}}>
      <View style={sAdd.header}>
        <View style={sAdd.top}>
          <Image
            source={require('./assets/Rectangle.png')}
            style={{ with: 45, height: 45, borderRadius: 100 }}
          />
          <View style={sTask.text}>
            <Text style={sTask.hi}>Hi Twinkle</Text>
            <Text>Have agrate day a head </Text>
          </View>
        </View>
        
      </View>
      <View style={sAdd.center}>
        <Text style={sAdd.addTitle}>ADD YOUR JOB</Text>
        <View style={sTask.inputText}>
          <Icon
            name="search"
            size={20}
            color="#000"
            style={{ marginRight: 5 }}
          />
          <TextInput
            style={styles.input}
            placeholder="input your job"
            placeholderTextColor="#888"
            onChangeText={(text) => setSearchQuery(text)}
            value={searchQuery}
          />
        </View>
        <TouchableOpacity style={sAdd.buttonView}
                          onPress ={addTask}
        >
              <Text style={sAdd.textButton}>FINISH -></Text>
        </TouchableOpacity>
      </View>
      <View style={sAdd.footer}>
        <Image source={require('./assets/Image95.png')} />
      </View>
    </View>
  );
};



//Chuyen trang
const Stack = createNativeStackNavigator();
const Navigating = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={Home} />
        <Stack.Screen name="Task" component={Task} />
        <Stack.Screen name="Add" component={Add} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};
export default Navigating;
