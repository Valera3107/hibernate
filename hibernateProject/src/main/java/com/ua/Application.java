package com.ua;

import com.ua.domain.User;
import com.ua.service.UserService;
import com.ua.util.HibernateUtil;

import java.util.Arrays;

public class Application {
  public static void main(String[] args) {
//    UserService userService = new UserService();
//    User user = userService.readById(1);
//    System.out.println(user);
//    user.setAge(43);
//    userService.update(user);
//    User updatedUser = userService.readById(1);
//    System.out.println(updatedUser);
//    HibernateUtil.shutdown();
    int[] arr = {6,54,8,4,536,55,67,7,84,34252,246,357,6,874,35,3636,0};
    selectedSort(arr);
    //sort(arr);
    //sort(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));
  }

  private static int[] selectedSort(int[] arr){
    for (int i = 0; i < arr.length; i++) {
      for (int j = i+1; j < arr.length; j++) {
        if(arr[i] > arr[j]){
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
    return arr;
  }

  private static int[] sort(int[] arr){
    boolean isSorted = false;

    while (!isSorted){
      isSorted=true;
      for (int i = 0; i < arr.length; i++) {
        if(i+1!=arr.length) {
          if (arr[i] > arr[i + 1]) {
            int temp = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = temp;
            isSorted=false;
          }
        }
      }
    }

    return arr;
  }

  private static int[] sort(int[] arr, int start, int end){
    if(start>=end) return arr;
    int i = start;
    int j = end;
    int op = i-(i-j)/2;

    while (i<j){
      while ((i<op)&&(arr[i] <= arr[op])) i++;
      while ((j>op)&&(arr[j] >= arr[op])) j--;

      if(i<j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        if(i==op) op = j;
        else if(j==op) op = i;
      }
    }

    sort(arr, start, op);
    sort(arr, op+1, end);

    return arr;
  }
}
