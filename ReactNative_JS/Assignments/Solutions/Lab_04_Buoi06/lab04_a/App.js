import React from 'react';
import {View,Text,ScrollView,FlatList,SafeAreaView ,Image ,StyleSheet} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';
import Icon1 from 'react-native-vector-icons/MaterialIcons';



const YourApp = () => {
  const DATA = [
  {
    id: '1',
    image : require('./assets/ca_nau_lau.png'),
    title: 'Ca nấu lẩu, nấu mì',
    shop :'Devang',

  },
  {
     id: '2',
    image : require('./assets/ga_bo_toi.png'),
    title: '1kg khô gà bơ tỏi',
    shop :'Devang',
  },
  {
     id: '3',
    image : require('./assets/xa_can_cau.png'),
    title: 'Xe cần cẩu đa năng',
    shop :'Devang',
  },
   {
     id: '4',
    image : require('./assets/xa_can_cau.png'),
    title: 'Xe cần cẩu đa năng',
    shop :'Devang',
  },
   {
     id: '5',
    image : require('./assets/xa_can_cau.png'),
    title: 'Xe cần cẩu đa năng',
    shop :'Devang',
  },
   {
     id: '6',
    image : require('./assets/ca_nau_lau.png'),
    title: 'Ca nấu lẩu, nấu mì',
    shop :'Devang',
  },
   {
     id: '7',
    image : require('./assets/lanh_dao_gian_don.png'),
    title: 'Lãnh đạo giản đơn',
    shop :'Devang',
  },
   {
     id: '8',
    image : require('./assets/xa_can_cau.png'),
    title: 'Xe cần cẩu đa năng',
    shop :'Devang',
  },
   {
     id: '9',
    image : require('./assets/xa_can_cau.png'),
    title: 'Xe cần cẩu đa năng',
    shop :'Devang',
  },
   {
     id: '10',
    image : require('./assets/xa_can_cau.png'),
    title: 'Xe cần cẩu đa năng',
    shop :'Devang',
  },
];

const Item = ({ item }) => (
  <View style={styles.items}>
    <View style={styles.topItems}>
        <Image 
           source={item.image} 
           style={styles.itemImage}
        />
        <View style={styles.titleShop}>
          <Text>{item.title}</Text>
          <Text>{item.shop}</Text>
       </View>
    </View>
    <View style={styles.chat}>
       <Text style={styles.textChat}> CHAT</Text>
    </View>
  </View>
);
  return (
     <View style ={styles.container}>
       <View style={styles.header}>  
           <Icon name="chevron-left" size={30} color="white" />
           <Text style={styles.textHeader}>Chat</Text>
           <Icon name="shopping-cart" size={30} color="white" />
       </View>
       <View style={styles.top}>     
              <Text style={styles.topText}>Bạn có thắc mắc sản phẩm vừa xem. Đừng ngần ngại chat với shop</Text>
       </View>
       <View style={styles.center}>  
            <ScrollView>
                <SafeAreaView style={styles.safe}>
                <FlatList
                       data={DATA}
                       renderItem={({ item }) => <Item item={item} />} // Truyền toàn bộ đối tượng item
                       keyExtractor={item => item.id}
                        />
               </SafeAreaView>
           </ScrollView >
       
       </View>
       <View style={styles.footer}>  
           <Icon1 name="menu" size={30} color="#000" />
           <Icon1 name="home" size={30} color="#000" />
           <Icon1 name="arrow-back" size={30} color="#000" />
       </View>
    </View>
   
  );
};
const styles = StyleSheet.create({
  container:{
    flex:1,
    
  },
  header:{
     flex:1,
     backgroundColor :'#1aa7ff',
     flexDirection:'row',
     justifyContent :'space-between',
     alignItems:'center',
     paddingTop:50,
     paddingHorizontal:20
  },
  textHeader:{
    fontSize:20,
    color:'white',
    fontWeight:'bold',
  },
  top:{
     flex:1,
      backgroundColor :'#e5e5e5',
      justifyContent :'center',
      alignItems:'center',
      paddingHorizontal :10,
  },
  topText:{
       fontSize:15,
  },
  center:{
     flex:9,
     backgroundColor :'#e5e5e5',

  },
  safe:{
    paddingHorizontal:20,
   
  },
  items:{
    flexDirection:'row',
     justifyContent : 'space-between',
     alignItems:'center',
     borderTopWidth: 1, 
     borderBottomWidth: 1,   
  },
  topItems:{
     flexDirection :'row',

  },
  titleShop: {
     paddingVertical :10,
     justifyContent :'flex-start',
     width:170,
     marginLeft:20

  },
  itemImage: {
    width:70,
    height:70,
  },

  footer:{
    flex:1,
    backgroundColor :'#1aa7ff',
    flexDirection:'row',
    justifyContent :'space-between',
    paddingHorizontal:20,
    paddingTop:10

  },
  chat:{
    backgroundColor:'red',
  },
  textChat :{
    fontSize:18,
    color:'white',
    padding:10,

  }
});

export default YourApp;