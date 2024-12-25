import React, { useState } from 'react';
import { View, Text, FlatList, Image, TouchableOpacity, StyleSheet, ActivityIndicator,SafeAreaView } from 'react-native';
import { MaterialIcons } from '@expo/vector-icons';
import useFetch from '../customHook/useAPI'; 
import { useFocusEffect } from '@react-navigation/native';

import { useCart } from '../customHook/useCart'; // Import hook useCart


const getImage = (imagePath) => {
  switch (imagePath) {
    case 'xe1.png':
      return require('../assets/bione-removebg-preview.png');
    case 'xe2.png':
      return require('../assets/bitwo-removebg-preview.png');
    case 'xe3.png':
      return require('../assets/bithree_removebg-preview.png');
    case 'xe4.png':
      return require('../assets/bifour_-removebg-preview.png');
    default:
      return require('../assets/bione-removebg-preview.png');
  }
};

const Screen3 = ({navigation, route}) => {

  const { addToCart } = useCart(); 

  const {bike} = route.params;

  const [isHearted, setIsHearted] = useState(bike.heart);

  const toggleHeart = async () => {
    setIsHearted(!isHearted); 
    
    try {
      await axios.put(`https://671001f7a85f4164ef2cc4c3.mockapi.io/api/bike/${bike.id}`, {
        ...bike,   /*giu nguyen thong tin cu */
        heart: !isHearted,   /*Cap nhat thong tin moi la heart */
      });
    } catch (error) {
      console.error("Error updating heart:", error);
    }
  };

  const them = () =>{
       addToCart(bike);
       navigation.navigate('Cart')
  }

  return (
     <SafeAreaView style ={screen3.container}>
            <View style={screen3.top}>
               <Image source ={getImage(bike.image)} style= {screen3.img}/>
            </View>
            <View style={screen3.center}>
                 <Text style={{fontWeight:'bold', fontSize:30,marginBottom :10}}>{bike.name}</Text>
                 <View style={{flexDirection:'row'}}>
                    <Text style={{color:'#6E6E6E', marginRight:30,fontSize:15}}>15% OFF I 350$</Text>
                     <Text style={{fontWeight:'bold', fontSize:15,textDecorationLine:'line-through'}}>449$</Text>
                 </View>
                 <Text style={{fontWeight:'bold', fontSize:15,marginVertical:20}}>Description</Text>
                 <Text style={{color:'#6E6E6E'}}>It is a very important form of writing as we write almost everything in paragraphs, be it an answer, essay, story, emails, etc.</Text>
            </View>
            <View style={screen3.footer}>
                 <TouchableOpacity
                     onPress ={toggleHeart}
                 >
                     <MaterialIcons
                     name = {'favorite'}
                     size= {40}
                     color={bike.heart ? 'red' :'gray'}
                     />
                 
                 </TouchableOpacity>

                 <TouchableOpacity style={screen3.button}
                                   onPress = {them}
                 >
                      <Text style={{fontWeight :'bold', color :'white', fontSize :20,textAlign:'center'}}>Add to cart</Text>
                 </TouchableOpacity>
            </View>

     </SafeAreaView>
  );
};

const screen3 = StyleSheet.create({
  container :{
     flex :1,
     padding :10,
     backgroundColor :'#ffffff'
  },
  top :{
     flex :2,
     backgroundColor :'#fdeded',
     margin :10
  },
  img :{
    width :'100%',
    height :'100%',
    resizeMode :'contain',
  },
  center :{
     flex :1,
     padding :10,
  },
  footer :{
     flex :0,
     flexDirection :'row',
     padding:10,
     justifyContent :'space-between',
     alignItems:'center'
  },
  button :{
    borderRadius :20,
    padding:10,
    backgroundColor:'#e94141',
    width :'80%'
  },
});

export default Screen3;