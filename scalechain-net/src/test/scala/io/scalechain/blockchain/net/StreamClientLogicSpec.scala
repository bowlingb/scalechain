package io.scalechain.blockchain.net

import java.net.{InetAddress, InetSocketAddress}

import akka.stream.ActorMaterializer

import scala.concurrent.duration._
import scala.concurrent.Future
import akka.actor._
import akka.testkit._
import org.scalatest._

class StreamClientLogicSpec extends TestKit(ActorSystem("StreamClientLogicSpec")) with ImplicitSender
with WordSpecLike with ShouldMatchers with BeforeAndAfterEach with BeforeAndAfterAll {
  this: Suite =>

  val REMOTE_ADDRESS = new InetSocketAddress( InetAddress.getByName("localhost"), 8333)


  var clientLogic : StreamClientLogic = null
  var peerSet : PeerSet = null

  override def beforeEach() {
    // set-up code
    //
    peerSet = new PeerSet()

    clientLogic = StreamClientLogic(system, ActorMaterializer(), peerSet, REMOTE_ADDRESS)
    super.beforeEach()
  }

  override def afterEach() {
    super.afterEach()

    // tear-down code
    //
  }

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "actor" should {
    "do something" in {
      /*
            val echo = system.actorOf(TestActors.echoActorProps)
            echo ! "hello world"
            expectMsg("hello world")
      */
    }
  }
}