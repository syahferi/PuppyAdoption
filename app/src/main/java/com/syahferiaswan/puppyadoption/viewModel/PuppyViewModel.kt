package com.syahferiaswan.puppyadoption.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syahferiaswan.puppyadoption.R
import com.syahferiaswan.puppyadoption.model.PuppyData

class PuppyViewModel : ViewModel() {
    private var puppyItems = MutableLiveData(listOf<PuppyData>())
    val puppyLiveData: LiveData<List<PuppyData>> = puppyItems

    fun fetchData() {
        val puppies: MutableList<PuppyData> = mutableListOf()
        puppies.add(
            PuppyData(
                name = "Parjiman",
                age = 4,
                type = "Akbash",
                image = R.drawable.dog1,
                desc = "The Akbash is a rare, purebred dog from the country of Turkey. Loyal, alert, and intelligent, these pups have some of the best qualities you could ask for."
            )
        )
        puppies.add(
            PuppyData(
                name = "Bambang",
                age = 4,
                type = "Beagler",
                image = R.drawable.dog2,
                desc = "The Beaglier is a mixed breed dog — a cross between the Beagle and Cavalier King Charles Spaniel dog breeds. Compact, energetic, and loyal, these pups inherited some of the best qualities from both of their parents.\n" +
                        "\n" +
                        "Beaglier is also spelled Beagalier and Beagelier. Despite their unfortunate status as a designer breed, you may find these pups, in shelters and rescues. So remember to adopt!"
            )
        )
        puppies.add(
            PuppyData(
                name = "Tejo",
                age = 2,
                type = "Clumber Spaniel",
                image = R.drawable.dog3,
                desc = "The Clumber Spaniel dog breed was originally created to find and retrieve game birds for hunters. Today, there is an effort to re-establish the Clumber Spaniel as an exceptional gundog, and many Clumber Spaniels compete in field trials.\n" +
                        "\n" +
                        "They can also be found in the show ring and competing in tracking, obedience, rally, and other dog sports. Last, but definitely not least, they make super family companions. If you’re looking for an intelligent, adaptable, and affectionate best friend, this may be the breed for you!"
            )
        )
        puppies.add(
            PuppyData(
                name = "Asep",
                age = 4,
                type = "Dachsador",
                image = R.drawable.dog4,
                desc = "The Dachsador is a mixed breed dog–a cross between the Dachshund and Labrador Retriever dog breeds. Lively, active, and friendly, these pups inherited some of the best qualities from both of their parents.\n" +
                        "\n" +
                        "Dachsadors are also sometimes known as Doxadors, Doxidors, and Weinerdors. You can find these mixed breed dogs in shelters and breed specific rescues, so remember to always adopt! Don’t shop if you’re looking to add a Dachsador to your home!"
            )
        )
        puppies.add(
            PuppyData(
                name = "Mantul",
                age = 3,
                type = "Daniff",
                image = R.drawable.dog5,
                desc = "The Daniff is a mixed breed dog — a cross between the English Mastiff and Great Dane dog breeds. Lovable, intelligent, and protective, these pups inherited the best qualities from both of their parents.\n" +
                        "\n" +
                        "Daniffs go by several names, including Mastidane, English Daniff, and Great Daniff. Despite the growing popularity of this designer breed, you can find these mixed breed dogs in shelters and breed specific rescues"
            )
        )

        puppyItems.value = puppies
    }
}